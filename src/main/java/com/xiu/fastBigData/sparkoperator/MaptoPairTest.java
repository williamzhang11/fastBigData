package com.xiu.fastBigData.sparkoperator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * mapToPair会对一个RDD中的每一个元素调用f函数,其中原来RDD中的每个元素都是T类型的,调用f函数后
 * 进行一定操作把每个元素转换成一个<K,V>类型对象
 */
public class MaptoPairTest {

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("maptopair");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","1","4","3");
        JavaRDD<String> rdd = sc.parallelize(list,2);

        JavaPairRDD<String ,String > pairRDD = rdd.mapToPair(v-> new Tuple2<String,String >(v,v+"_"+v));

        pairRDD.mapPartitionsWithIndex(
                (Integer index,Iterator<Tuple2<String,String>> v)->{
                    System.out.println("partitions index is:"+index);
                    v.forEachRemaining(v1->System.out.println(v1));
                    return v;
                }
        ,false).collect();
    }
}
