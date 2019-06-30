package com.xiu.fastBigData.sparkoperator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 *
 */
public class flatMaptoPairTest {

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("maptopair");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","1","4","3");
        JavaRDD<String> rdd = sc.parallelize(list,2);

        JavaPairRDD<String ,String > pairRDD =
                rdd.flatMapToPair(v->{
                    System.out.println("=========");
                    List<Tuple2<String,String>> list1 = new ArrayList();
                    list1.add(new Tuple2(v,v+"_"+v));
                    return list1.iterator();
                });

        pairRDD.mapPartitionsWithIndex(
                (Integer index,Iterator<Tuple2<String,String>> v)->{
                    System.out.println("partitions index is:"+index);
                    v.forEachRemaining(v1->System.out.println("value="+v1));
                    return v;
                }
        ,false).collect();
    }
}
