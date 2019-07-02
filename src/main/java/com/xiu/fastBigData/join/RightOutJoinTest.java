package com.xiu.fastBigData.join;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class RightOutJoinTest {

    public static  void  main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("join算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        JavaPairRDD<String,String> rdd1 = sc.parallelize(Arrays.asList("1","2","3","4","5"),2)
                .mapToPair(v->new Tuple2<String,String>(v,v+"a"));
        rdd1.mapPartitionsWithIndex((Integer index ,Iterator<Tuple2<String,String>> v)-> {
            System.out.println("first data partitions index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        JavaPairRDD<String,String> rdd2 = sc.parallelize(Arrays.asList("1","2","3","4","6"),2)
                .mapToPair(v->new Tuple2<String,String>(v,v+"b"));
        rdd2.mapPartitionsWithIndex((Integer index ,Iterator<Tuple2<String,String>> v)-> {
            System.out.println("second data partitions index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();

        JavaPairRDD<String,Tuple2<Optional<String>,String>> rdd3 = rdd1.rightOuterJoin(rdd2);

        rdd3.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Tuple2<Optional<String>,String>>> v)->{

            System.out.println("join data partitions index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect() ;








    }
}
