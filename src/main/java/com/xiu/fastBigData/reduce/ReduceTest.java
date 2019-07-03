package com.xiu.fastBigData.reduce;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("top");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> list = Arrays.asList(1,2,3);
        JavaRDD<Integer> rdd = sc.parallelize(list,2);
        sc.setLogLevel("error");
        rdd.mapPartitionsWithIndex((Integer index, Iterator<Integer> v)->{
            System.out.println("partitions index is"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return  v;
        },false).collect();


    }
}