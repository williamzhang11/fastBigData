# spark介绍

## 什么是spark
	ApacheSpark是专为大规模数据处理而设计的快速通用计算引擎.
	Spark使用Scala语言实现，它是一种面向对象，函数式编程语言，能够像操作本地集合对象一样轻松操作分布式数据集。
## spark特点
	1.运行速度快
		spark拥有DAG执行引擎，支持在内存中对数据进行迭代计算，如果数据由磁盘读取，速度是Hadoop的10倍以上，如果内存中读取，速度是hadoop100多倍
	2.易用性好
		spark不仅支持Scala编写应用程序，而且支持java和python等语言进行编写，特别是scala是一种高效，可扩展的语言，能够用简洁代码处理较为复杂工作
	3.通用性
		spark提供大量库，包括sql,DataFrames，MLib,GraphX,Spark Streaming.开发者可在同一个应用程序中无缝组合使用这些库。
	4.支持多种资源管理器
		spark支持hadoop yarn,apache mesos,及其自带的独立集群管理器
	
## spark生态体系
	spark生态圈也成为BDAS（伯克利数据分析栈），是伯克利APMLab实验室打造，力图在算法，机器，人之间通过大规模集成来展现大数据应用的一个平台。
	
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/sparkinfo/image/union.jpg)

	1.Spark Core
		Spark Core实现Spark基本功能，包含任务调度，内存管理，错误恢复，与存储系统交互等模块。还包括对弹性分布式数据集（RDD）的API定义，RDD
	表示分布在多个计算机节点上可以并行操作的元素集合，是Spark主要的编程抽象
	2.Spark SQL
		本质上是通过Hive的HQL解析，把HQL翻译成Spark上的RDD操作，然后通过Hive的metadata获取数据库里的表信息，实际HDFS上的数据和文件，会由
	Shark获取并放到Spark上运算。SparkSql支持多种数据源，如：hive,json等
	3.Spark Streaming
		SparkStreaming是一个对实时数据流进行高通量，容错处理的流式处理系统，可对多种数据源（kafka,flume,twitter,zero和tcp套接字）进行
	类似Map,Reduce和Join等复杂操作，并将结果保存到外部文件系统，数据库或应用到实时仪表盘。SparkStreaming提供用来操作数据流的API，并且与RDD 	API高度对应。
	内部原理：Spark Streaming是将流式计算分解成一系列短小的批处理作业。这里的批处理引擎是spark core,也就是把spark streamingd的输入数据按照
	batch size(如1s)分成一段一段的数据（Discretized Stream）,每一段数据都转换成Spark中的RDD(Resilient Distributed DataSet)
	，然后将spark streaming中对DStream 的Transformation操作，将RDD经过操作变成中间结果保存在内存中。整个流式计算根据业务的需求可以对中间
	的结果进行叠加或者存储到外部设备。
		
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/sparkinfo/image/sparkstream.jpg)
	4.MLib
	MLlib是一个机器学习库，他提供各种各样算法，这些算法用来在集群上针对分类，回归，聚类，协同过滤等。其中一些算法也可以应用
	到流数据上，如使用普通最小二乘法或者K均值聚类来计算线性回归。Apache Mahout(一个针对Hadoop的机器学习库)已经脱离
	MapReduce,转而加入Spark MLlib
	5.GraphX
		GraphX是spark中用于图和图并行计算的API,可以认为是GraphLab在Spark上的重写和优化，跟其他分布式图计算框架相比，Graphx
		最大贡献是，在spark之上提供一栈式数据解决方案，可以方便且高效完成图计算的一整套流水作业。

## spark的适用场景
	1.复杂的批处理，重点在于处理海量数据能力，至于处理速度可忍受，通常时间在数十分钟到数小时。
	2.数据量不是特别大，但要求实时统计分析需求（实时计算）
	3.spark是基于内存的迭代计算框架，适用于需要多次操作特定数据集的应用场合，需要反复操作的次数越多，所需读取的数据量越大，受益越大。数据量小，但计算密度
	较大的场合受益越小。
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/sparkinfo/image/streaming-arch.jpg)
## spark的运行模式
	1.Local本地模式 常用于本地开发测试，本地还分为local单线程和local-cluster多线程
	2.Standalone集群模式 典型的Mater/Slave模式。Master是有单点故障；spark支持Zookeeper来实现HA
	3.On yarn 集群模式 运行在yarn资源管理器框架上，由yarn负责资源管理，spark负责任务调度和计算
	4.On mesos集群模式 运行在mesos资源管理器框架之上，由mesos负责资源管理，spark负责任务调度和计算
## Spark基本原理
	Spark运行框架如下图，首先由集群资源管理服务（Cluster Manager）、运行作业任务的节点（Worker Node）、每个应用的任务控制节点Driver和
	每个机器节点上有具体任务的执行进程组成。
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/sparkinfo/image/sparkexec.jpg)

	执行流程：首先Driver程序启动多个worker，worker从文件系统加载数据并产生RDD,并按照不同分区Cache到内存。
	
	
## Spark RDD介绍
	RDD是spark的核心内容之一，RDD的中文解释为：弹性分布式数据集.即内存中的数据库。RDD只读，可分区，这个数据集的全部或部分可缓存在内存中，在多次计算间
	可重用。所谓弹性，是指内存不够时可与磁盘进行交换。内存计算，就是将数据保存到内存中，同时，为解决内存容量限制问题，spark为我们提供最大自由度，所有数据
	均可由我们进行cache设置。
	
## spark任务提交
	spark-submit提交可指定各种参数
	./bin/spark-submit\
	--class\
	--master\
	--deploy-mode\
	-conf=\
	
	--class:一个spark任务的入口方法，一般指main方法。如：org.apache.spark.examples.SparkPi)
	-master:集群的master URL。如spark://127.0.0.1:7077
	--deploy-mode:部署方式，有cluster何client两种方式，默认为client
	--conf:额外的属性
	application-jar:指定的jar目录，路径必须在整个集群当中可见
	application-argument:main方法的参数
	












转载并参考：http://www.ccblog.cn/99.htm