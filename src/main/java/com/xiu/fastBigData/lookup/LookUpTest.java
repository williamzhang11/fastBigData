package com.xiu.fastBigData.lookup;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LookUpTest {
    public static void main(String [] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","4","1","2","3","4","5");
        JavaRDD<String> rdd = sc.parallelize(list,2);

        JavaPairRDD<String,Integer> rdd1 =rdd.mapToPair(v->new Tuple2<String,Integer>(v,Integer.valueOf(v)));

        rdd1.mapPartitionsWithIndex((Integer index ,Iterator<Tuple2<String,Integer>> v)-> {
            System.out.println("before partitions index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        List<Integer> list1 = rdd1.lookup("5");
        System.out.println(list1);

    }
}