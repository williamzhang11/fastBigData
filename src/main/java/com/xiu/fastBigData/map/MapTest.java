package com.xiu.fastBigData.map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapTest
{
    public static void  main(String []args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapTest");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<String> list = Arrays.asList("a_b","c_d","e_f");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        sc.setLogLevel("error");
        rdd.mapPartitionsWithIndex((Integer v1, Iterator<String> v2) -> {
            System.out.println("before index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();

        JavaRDD<String[]> rdd2 = rdd.map((String v1) -> {

            return v1.split("_");
        });

        rdd2.mapPartitionsWithIndex((Integer v1, Iterator<String[]> v2) -> {
            System.out.println("after index is:"+v1);
            while(v2.hasNext()){
                System.out.println(Arrays.toString(v2.next()));
            }
            return v2;
        },false).collect();


    }
}
