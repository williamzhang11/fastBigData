package com.xiu.fastBigData.union;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

public class UnionTest {

	public static void main(String[] args) {
		
		System.out.println(".............begin.......");
		SparkConf conf = new SparkConf().setAppName("SparkTest").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
		List<Integer> numbers2 = Arrays.asList(6,7,8,9,10);
		
		JavaRDD<Integer>  numbersRDD1 = sc.parallelize(numbers1, 2);

		numbersRDD1.mapPartitionsWithIndex((Integer v1,Iterator<Integer> v2) -> {

			System.out.println("numbersRDD1 Partitions index is:" + v1);

			while (v2.hasNext()){
				System.out.println("Partitions index is:" + v2.next());
			}
			return v2;
		},false).collect();


		JavaRDD<Integer>  numbersRDD2 = sc.parallelize(numbers2, 3);

		numbersRDD2.mapPartitionsWithIndex(
				new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {

					private static final long serialVersionUID = 1L;

					public Iterator<Integer> call(Integer id, Iterator<Integer> iter) throws Exception {

						System.out.println("numbersRDD2 partition id is:"+id +"\tvalue is: ");
						while (iter.hasNext()) {
							int val = iter.next();
							System.out.print(val + "\t" );
						}

						System.out.println();
						return iter;
					}

		}, false).collect();
		
		
		System.err.println("====="+numbersRDD1.partitions().size());
		System.err.println("====="+numbersRDD2.partitions().size());
		
		JavaRDD<Integer> unionRDD = numbersRDD1.union(numbersRDD2);
		System.out.println("\n partition size is "+unionRDD.partitions().size());

		 unionRDD.mapPartitionsWithIndex(
				new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {

					private static final long serialVersionUID = 1L;

					public Iterator<Integer> call(Integer id, Iterator<Integer> iter) throws Exception {

						System.out.println("unionRDD partition id is:"+id +"\tvalue is: ");
						while (iter.hasNext()) {
							int val = iter.next();
							System.out.print(val + "\t" );
						}

						System.out.println();
						return iter;
					}

				}, false).collect();




		sc.close();
		System.out.println(".............end.......");
		
	}
	
}
