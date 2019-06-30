package com.xiu.fastBigData.flatMap;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlatMapTest {

    public static void main(String [] args) {

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapTest");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<String> list = Arrays.asList("a_b","c_d","e_f");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        sc.setLogLevel("error");
        rdd.mapPartitionsWithIndex((Integer v1, Iterator<String> v2) -> {
            System.out.println("before1 index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();

        JavaRDD<String> rdd2 = rdd.flatMap(v->Arrays.asList(v.split("_")).iterator() );


        rdd2.mapPartitionsWithIndex((Integer v1, Iterator<String> v2) -> {
            System.out.println("after1 index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();


    }
}
