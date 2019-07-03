 本项目主要是整理 大数据开发中常用的技术。 目录结构为：com.xiu.fastBigData下的每个包中都有一种， 以及详细的解释。
 
 本项目为maven项目，直接使用maven方式导入即可。

## 目前已整理的技术以及对应的包名如下：
|技术|包路径|
| :------ | :------ |
|spark介绍						|               com.xiu.fastBigData.sparkinfo |
|sparkRDD						|				com.xiu.fastBigData.sparkrdd |
|spark常用算子介绍 				|				com.xiu.fastBigData.sparkoperator |
|spark Map算子 					|				com.xiu.fastBigData.map |
|spark flatMap算子 				|				com.xiu.fastBigData.flatMap |
|spark mapPartitions算子 		|				com.xiu.fastBigData.mapPartitions |
|spark glom算子                 |               com.xiu.fastBigData.glom |
|spark union算子 				|				com.xiu.fastBigData.union |
|spark cartesian算子 			|				com.xiu.fastBigData.cartesian |
|spark groupby算子 			    |				com.xiu.fastBigData.groupby |
|spark filter算子               |               com.xiu.fastBigData.filter |
|spark distinct算子             |               com.xiu.fastBigData.distinct |
|spark subtract算子             |               com.xiu.fastBigData.subtract |
|spark sample算子               |               com.xiu.fastBigData.sample |
|spark takeSample算子           |               com.xiu.fastBigData.takeSample |
|spark cache算子                |               com.xiu.fastBigData.cache |
|spark persist算子              |               com.xiu.fastBigData.persist|
|spark mapValues算子            |               com.xiu.fastBigData.mapvalues |
|spark combineBykey算子         |               com.xiu.fastBigData.combinebykey |
|spark reduceByKey算子          |               com.xiu.fastBigData.reducebykey |
|spark partitionBy算子          |               com.xiu.fastBigData.partitionby |
|spark cogroup算子              |               com.xiu.fastBigData.cogroup|
|spark join算子                 |               com.xiu.fastBigData.join |
|spark foreach算子              |               com.xiu.fastBigData.foreach |
|spark saveAsTextFile算子       |               com.xiu.fastBigData.saveastextfile |
|spark saveAsObjectFile算子     |               com.xiu.fastBigData.saveasobjectfile |
|spark collect算子              |               com.xiu.fastBigData.collect |
|spark collectAsMap算子         |               com.xiu.fastBigData.collectasmap |
|spark reduceByKeyLocally算子   |               com.xiu.fastBigData.reducebykeylocally |
|spark lookup算子               |               com.xiu.fastBigData.lookup |
|spark count算子                |               com.xiu.fastBigData.count |
|spark top算子                  |               com.xiu.fastBigData.top |
|spark reduce算子               |               com.xiu.fastBigData.reduce |
|spark fold算子                 |               com.xiu.fastBigData.fold |
|spark aggregate算子            |               com.xiu.fastBigData.aggregate |






## 附:idea配置支持lambda

    1.file->Project Structure->Modules->再选择指定的代码模块，在Language Level选项选择“8 – Lambda,type annotations etc.”选项
    2.修改字节码版本设置，file->setting->左上角的搜索框中输入java compiler->javac->Project bytecode version 1.8
    Target bytecode version 改成1.8




	