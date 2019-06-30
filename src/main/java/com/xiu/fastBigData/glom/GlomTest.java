package com.xiu.fastBigData.glom;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GlomTest {

    public static void main(String [] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        JavaRDD<Integer> rdd = sc.parallelize(list,2);
        rdd.mapPartitionsWithIndex((Integer v1, Iterator<Integer> v2)->{
            System.out.println("partitions index is:"+v1);
            v2.forEachRemaining(v->System.out.println(v));
            return  v2;
        },false).collect();

        JavaRDD<List<Integer>> rdd1 = rdd.glom();

        rdd1.mapPartitionsWithIndex((Integer index,Iterator<List<Integer>> v2)->{
            System.out.println("partitions index is "+index);
            v2.forEachRemaining(v->System.out.println(v));

            return v2;
        },false).collect();



    }
}
