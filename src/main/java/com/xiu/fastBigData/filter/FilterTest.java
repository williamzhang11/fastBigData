package com.xiu.fastBigData.filter;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FilterTest {

    public static void main(String [] args){
        SparkConf conf = new SparkConf().setMaster("local").setAppName("sparkfilter算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
            sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","4","5");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        rdd.mapPartitionsWithIndex((Integer v1, Iterator<String> v2) -> {
            System.out.println("partition index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();

        rdd.filter(v-> v.equals("1")).mapPartitionsWithIndex((Integer v1, Iterator<String> v2) -> {
            System.out.println("after filter partition index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();

    }
}
