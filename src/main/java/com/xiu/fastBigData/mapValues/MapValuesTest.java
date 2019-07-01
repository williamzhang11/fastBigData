package com.xiu.fastBigData.mapValues;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapValuesTest {

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("distinct算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        JavaRDD<Integer> rdd1 = sc.parallelize(list1, 2);
        rdd1.mapPartitionsWithIndex((Integer index, Iterator<Integer> v) -> {
            System.out.println("before  partitions index is :" + index);
            v.forEachRemaining(v1 -> System.out.println(v1));
            return v;
        }, false).collect();
        JavaPairRDD<Integer,Integer> rdd2 = rdd1.mapToPair(v->new Tuple2<Integer,Integer>(v,v+2));

        rdd2.mapPartitionsWithIndex((Integer index, Iterator<Tuple2<Integer,Integer>> v) -> {
            System.out.println(" deal partitions index is :" + index);
            v.forEachRemaining(v1 -> System.out.println(v1));
            return v;
        }, false).collect();


        JavaPairRDD<Integer,Integer> rdd3 = rdd2.mapValues(v1->v1+2);

        rdd3.mapPartitionsWithIndex((Integer index, Iterator<Tuple2<Integer,Integer>> v) -> {
            System.out.println("after deal partitions index is :" + index);
            v.forEachRemaining(v1 -> System.out.println(v1));
            return v;
        }, false).collect();





    }
}
