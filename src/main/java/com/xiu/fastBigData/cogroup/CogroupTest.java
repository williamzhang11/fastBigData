package com.xiu.fastBigData.cogroup;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CogroupTest {

    public static void main(String [] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","4","1","1");
        JavaRDD<String> rdd = sc.parallelize(list,3);
        JavaPairRDD<String,Integer> rdd1 = rdd.mapToPair(v->new Tuple2<String,Integer>(v,Integer.valueOf(v)));
        rdd1.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Integer>> v)->
        {
            System.out.println("before1 Partition index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        List<String> list1 = Arrays.asList("1","2","3","4","1","1");
        JavaRDD<String> rdd2 = sc.parallelize(list,2);
        JavaPairRDD<String,Integer> rdd3 = rdd2.mapToPair(v->new Tuple2<String,Integer>(v,Integer.valueOf(v)));
        rdd3.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Integer>> v)->
        {
            System.out.println("before2 Partition index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        JavaPairRDD<String,Tuple2<Iterable<Integer>, Iterable<Integer>>> rdd4 = rdd1.cogroup(rdd3);

        rdd4.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Tuple2<Iterable<Integer>,Iterable<Integer>>>> v)->{

            System.out.println("partition11 index:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;

        },false).collect();




    }

}
