package com.xiu.fastBigData.partitionByTest;

import org.apache.spark.Partitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PartitionByTest {

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setMaster("local").setAppName("mapPartitions算子");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("error");
        List<String> list = Arrays.asList("1","2","3","4","1","2","3","4");
        JavaRDD<String> rdd = sc.parallelize(list,2);
        JavaPairRDD<String,Integer> rdd1 = rdd.mapToPair(v->new Tuple2<String,Integer>(v,Integer.valueOf(v)));
        rdd1.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Integer>> v)->
        {
            System.out.println("before Partition index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
        return v;
        },false).collect();

        Partitioner partitioner = new Partitioner() {
            @Override
            public int numPartitions() {
                return 3;
            }

            @Override
            public int getPartition(Object key) {
                if(Integer.valueOf(key.toString())%2==0){
                    return 0;
                }
                return 1;
            }
        };

        JavaPairRDD<String, Integer> rdd2 =rdd1.partitionBy(partitioner);
        rdd2.mapPartitionsWithIndex((Integer index,Iterator<Tuple2<String,Integer>> v)->
        {
            System.out.println("after Partition index is:"+index);
            v.forEachRemaining(v1->System.out.println(v1));
            return v;
        },false).collect();


    }
}
