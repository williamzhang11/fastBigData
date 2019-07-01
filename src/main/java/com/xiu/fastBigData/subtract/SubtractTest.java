package com.xiu.fastBigData.subtract;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Int;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SubtractTest {

    public static void main(String[] args ){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("distinct算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<Integer> list1 = Arrays.asList(1,1,2,3,4,5,1,2,3);
        JavaRDD<Integer> rdd1 = sc.parallelize(list1,2);

        List<Integer> list2 = Arrays.asList(5,6,7,3);
        JavaRDD<Integer> rdd2 = sc.parallelize(list2,2);

        rdd1.mapPartitionsWithIndex((Integer index, Iterator<Integer> v)->{
            System.out.println("before rdd1 deal partitions index is :"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        rdd2.mapPartitionsWithIndex((Integer index, Iterator<Integer> v)->{
            System.out.println("before rdd2 deal partitions index is :"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        JavaRDD<Integer> rdd3= rdd1.subtract(rdd2);

        rdd3.mapPartitionsWithIndex((Integer index,Iterator<Integer> v)->{

            System.out.println("after rdd3 partitions index is"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return  v;
        },false).collect();


    }
}
