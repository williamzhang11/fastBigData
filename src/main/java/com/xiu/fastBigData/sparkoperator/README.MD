# spark算子分类
## spark算子大致可分为以下两类

	1）Transformation变换/转化算子：这种变换不触发提交作业，完成作业中间过程处理。
		Transformation操作时延迟计算的，也就是从一个RDD转换成另一个RDD的转换操作不是马上执行，需要
	等到有Action操作时才会真正触发运算。
	2）Action行动算子：这类算子会触发SparkContext提交job作业
		Action算子会触发spark提交作业（job）,并将数据输出spark系统
	
	从小方向来说，spark算子大致分为以下3类：
	1）value数据类型的Transformation算子，这种变换并不触发提交作业，针对处理的数据项是value型数据。
		一、输入分区与输出分区一对一型
			1，map算子
			2，flatmap算子
			3，mapPartition算子
			4，glom算子
		二、输入分区与输出分区多对一型
			5，union算子
			6，cartesian算子
		三、输入分区与输出分区多对多型
			7，groupBy算子
		四、输出分区为输入分区子集型
			8，filter算子
			9，distinct算子
			10，subtract算子
			11，sample算子
			12，takeSample算子
		五、Cache型
		13，cache算子
		14，persist算子
	2）key-value数据类型的Transformation算子，这种变换不触发提交作业，针对处理的数据项是key-value型的数据对
	
		一、输入分区与输出分区一对一
		15，mapValues算子
		二、对单个RDD或两个RDD聚集
			单个RDD聚集
				16，combineByKey算子
				17，reduceByKey算子
				18，partitionBy算子
			两个RDD聚集
				19，Cogroup算子
		三、连接
			20、join算子
			21、leftOutJoin和rightOutJoin算子
	
	3）Action算子，这类会触发sparkContext提交job作业。
		一、无输出
			22，foreach算子
		二、HDFS
			23,saveAsTextFile算子
			24，saveAsObjectFile算子
		三、Scala集合和数据类型
			25、collect算子
			26、collectAsMap算子
			27、reduceByKeyLocally算子
			28、lookup算子
			29、count算子
			30、top算子
			31、reduce算子
			32、fold算子
			33、aggregate算子
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		