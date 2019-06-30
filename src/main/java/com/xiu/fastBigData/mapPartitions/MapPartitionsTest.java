package com.xiu.fastBigData.mapPartitions;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MapPartitionsTest {

    public static void main(String args []){
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
       /* rdd.mapPartitionsWithIndex((Integer v1, Iterator<Integer> v2) -> {
            System.out.println("before index is:"+v1);
            while(v2.hasNext()){
                System.out.println(v2.next());
            }
            return v2;
        },false).collect();*/

        JavaRDD<Integer> rdd1 = rdd.mapPartitions((Iterator<Integer> v) -> {
            System.out.println("=======================");
            List<Integer> list1 = new ArrayList<>();
            v.forEachRemaining(v2->list1.add(2*v2));

            return  list1.iterator();

        });
        //rdd1.foreach(v->System.out.println("value="+v));
        rdd1.mapPartitionsWithIndex((Integer v1, Iterator<Integer> v2)->{
            System.out.println("partitions1 index is:"+v1);
            v2.forEachRemaining(v->System.out.println(v));
            return  v2;
        },false).collect();

    }
}
