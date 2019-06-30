package com.xiu.fastBigData.cartesian;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CartesianTest {

    public static void main(String [] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        JavaRDD<Integer> rdd1 = sc.parallelize(list1,2);
        List<Integer> list2 = Arrays.asList(6,7,8,9,10);
        JavaRDD<Integer> rdd2 = sc.parallelize(list2,2);

        rdd1.mapPartitionsWithIndex((Integer v1, Iterator<Integer> v2)->{
            System.out.println("rdd1 partitions index is:"+v1);
            v2.forEachRemaining(v->System.out.println(v));
            return  v2;
        },false).collect();

        rdd2.mapPartitionsWithIndex((Integer v1, Iterator<Integer> v2)->{
            System.out.println("rdd2 partitions index is:"+v1);
            v2.forEachRemaining(v->System.out.println(v));
            return  v2;
        },false).collect();

        JavaPairRDD<Integer,Integer> rdd3 = rdd1.cartesian(rdd2);

        rdd3.mapPartitionsWithIndex((Integer v1, Iterator<Tuple2<Integer,Integer>> v2)->{
            System.out.println("rdd3 partitions index is:"+v1);
            v2.forEachRemaining(v->System.out.println(v));
            return  v2;
        },false).collect();



    }
}
