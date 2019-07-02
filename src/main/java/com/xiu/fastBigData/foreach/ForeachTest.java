package com.xiu.fastBigData.foreach;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class ForeachTest {
    public static void main(String [] args) {

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapTest");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<String> list = Arrays.asList("a_b","c_d","e_f");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        sc.setLogLevel("error");
        rdd.foreach(v->System.out.println(v));
    }
}
