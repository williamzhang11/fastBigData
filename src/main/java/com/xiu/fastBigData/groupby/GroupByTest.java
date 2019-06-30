package com.xiu.fastBigData.groupby;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GroupByTest {

    public static void main(String [] args){
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

        JavaPairRDD<String,Iterable<Tuple2<String,String>>> rdd2 = rdd1.groupBy(v1 -> v1._1);

        /*rdd2.mapPartitionsWithIndex((Integer index, Iterator<Tuple2<String,Iterable<Tuple2<String,String>>>>v)->{
            System.out.println("after partitions index is:"+index);

            List<Tuple2<String,Iterable<Tuple2<String,String>>>> list3 = new ArrayList<>();
            v.forEachRemaining(v1->{
                System.out.println(v1);
            });
            return list3.iterator();
        },false).collect();*/
        rdd2.mapPartitionsWithIndex((Integer index, Iterator<Tuple2<String,Iterable<Tuple2<String,String>>>>v)->{
            System.out.println("after partitions index is:"+index);

            List<Tuple2<String,Iterable<Tuple2<String,String>>>> list3 = new ArrayList<>();
            v.forEachRemaining(v1->{
                System.out.println(v1);
            });
            return list3.iterator();
        },false).collect();



    }
}
