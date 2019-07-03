package com.xiu.fastBigData.collectasmap;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CollectAsMapTest {

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapTest");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<String> list = Arrays.asList("a","c","e","a");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        sc.setLogLevel("error");
        JavaPairRDD<String,String> rdd1 = rdd.mapToPair(v-> new Tuple2(v,v+"_C"));
        Map<String,String> map = rdd1.collectAsMap();
        System.out.println(map);

    }
}
