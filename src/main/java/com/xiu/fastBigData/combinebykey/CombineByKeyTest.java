package com.xiu.fastBigData.combinebykey;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombineByKeyTest
{
    public static  void  main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","1","4","3","5","6","6");
        JavaRDD<String> rdd = sc.parallelize(list,2);

        JavaPairRDD<String,String> rdd1 =rdd.mapToPair(v->new Tuple2<String,String>(v,v+"_"+v));

        rdd1.mapPartitionsWithIndex((Integer index ,Iterator<Tuple2<String,String>> v)-> {
            System.out.println("after partitions index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();


    }
}
