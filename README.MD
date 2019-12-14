 本项目主要是整理 大数据开发中常用的技术。 目录结构为：com.xiu.fastBigData下的每个包中都有一种， 以及详细的解释。
 
 本项目为maven项目，直接使用maven方式导入即可。

## 目前已整理的技术以及对应的包名如下：
|技术|
| :------ |
|[spark介绍](src/main/java/com/xiu/fastBigData/sparkinfo/README.MD)|
|[sparkRDD](src/main/java/com/xiu/fastBigData/sparkrdd/README.MD)|
|[spark常用算子介绍 ](src/main/java/com/xiu/fastBigData/sparkoperator/README.MD)|
|[spark Map算子](src/main/java/com/xiu/fastBigData/map/README.MD)|
|[spark flatMap算子](src/main/java/com/xiu/fastBigData/flatMap/README.MD)|
|[spark mapPartitions算子 ](src/main/java/com/xiu/fastBigData/mapPartitions/README.MD)|
|[spark glom算子](src/main/java/com/xiu/fastBigData/glom/README.MD)|
|[spark union算子](src/main/java/com/xiu/fastBigData/union/README.MD)|
|[spark cartesian算子 ](src/main/java/com/xiu/fastBigData/cartesian/README.MD)|
|[spark groupby算子](src/main/java/com/xiu/fastBigData/groupby/README.MD)|
|[spark filter算子 ](src/main/java/com/xiu/fastBigData/filter/README.MD)|
|[spark distinct算子 ](src/main/java/com/xiu/fastBigData/distinct/README.MD)|
|[spark subtract算子](src/main/java/com/xiu/fastBigData/subtract/README.MD)|
|[spark sample算子  ](src/main/java/com/xiu/fastBigData/sample/README.MD)|
|[spark takeSample算子  ](src/main/java/com/xiu/fastBigData/takeSample/README.MD)|
|[spark cache算子](src/main/java/com/xiu/fastBigData/cache/README.MD)|
|[spark persist算子 ](src/main/java/com/xiu/fastBigData/persist/README.MD)|
|[spark mapValues算子 ](src/main/java/com/xiu/fastBigData/mapValues/README.MD)|
|[spark combineBykey算子](src/main/java/com/xiu/fastBigData/mapValues/README.MD)|
|[spark reduceByKey算子](src/main/java/com/xiu/fastBigData/reduceByKey/README.MD) |
|[spark partitionBy算子 ](src/main/java/com/xiu/fastBigData/partitionBy/README.MD)|
|[spark cogroup算子](src/main/java/com/xiu/fastBigData/cogroup/README.MD)|
|[spark join算子 ](src/main/java/com/xiu/fastBigData/join/README.MD)|
|[spark foreach算子 ](src/main/java/com/xiu/fastBigData/foreach/README.MD)|
|[spark saveAsTextFile算子 ](src/main/java/com/xiu/fastBigData/saveAsTextFile/README.MD)|
|[spark saveAsObjectFile算子](src/main/java/com/xiu/fastBigData/saveAsObjectFile/README.MD)|
|[spark collect算子 ](src/main/java/com/xiu/fastBigData/collect/README.MD)|
|[spark collectAsMap算子](src/main/java/com/xiu/fastBigData/collectAsMap/README.MD)|
|[spark reduceByKeyLocally算子](src/main/java/com/xiu/fastBigData/reduceByKeyLocally/README.MD)|
|[spark lookup算子](src/main/java/com/xiu/fastBigData/lookup/README.MD)|
|[spark count算子 ](src/main/java/com/xiu/fastBigData/count/README.MD)|
|[spark top算子](src/main/java/com/xiu/fastBigData/top/README.MD)|
|[spark reduce算子](src/main/java/com/xiu/fastBigData/reduce/README.MD)|
|[spark fold算子](src/main/java/com/xiu/fastBigData/fold/README.MD)|
|[spark aggregate算子](src/main/java/com/xiu/fastBigData/aggregate/README.MD)|






## 附:idea配置支持lambda

    1.file->Project Structure->Modules->再选择指定的代码模块，在Language Level选项选择“8 – Lambda,type annotations etc.”选项
    2.修改字节码版本设置，file->setting->左上角的搜索框中输入java compiler->javac->Project bytecode version 1.8
    Target bytecode version 改成1.8




	