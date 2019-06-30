# spark RDD操作

## RDD介绍
	RDD，全称resilient Distributed Datasets，弹性分布式数据集，是spark最核心概念，是spark对数据的抽象。RDD是分布式元素集合，每个RDD
	只支持读操作，且每个RDD被分为多个分区存储到集群的不同节点上。除此之外，RDD还允许用户显示的指定数据存储到内存和磁盘中。
## RDD 操作
	1.creation操作：RDD的创建由SparkContext负责
	2.transformation操作：将一个RDD通过一定操作转换为另一个RDD
	3.action操作：spark为惰性计算，对RDD的行动操作都会触发spark作业的运行
	4.control操作：对RDD进行持久化

### 创建操作
	有2种创建方式：
	1.读取一个数据集（SparkContext.textFile()）
	2.读取一个集合（SparkContext.parallelize()）
```
		SparkConf conf = new SparkConf().setAppName("SparkTest").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<Integer>  numbersRDD1 = sc.parallelize(numbers1, 2);

```
### 转换操作
1.单个RDD转换
map():对每个元素进行操作，返回一个新的RDD












