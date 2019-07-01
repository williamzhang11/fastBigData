package com.xiu.fastBigData.cache;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CacheTest {

    public static void  main(String args[]) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("distinct算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        JavaRDD<Integer> rdd1 = sc.parallelize(list1, 2);
        rdd1.mapPartitionsWithIndex((Integer index, Iterator<Integer> v) -> {
            System.out.println("before deal partitions index is :" + index);
            v.forEachRemaining(v1 -> System.out.println(v1));
            return v;
        }, false).collect();

        JavaRDD<Integer> rdd2 = rdd1.cache();

        rdd2.mapPartitionsWithIndex((Integer index, Iterator<Integer> v) -> {
            System.out.println("before deal partitions index is :" + index);
            v.forEachRemaining(v1 -> System.out.println(v1));
            return v;
        }, false).collect();

    }
}