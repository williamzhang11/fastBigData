# partitionBy

    partitionBy函数对RDD进行分区操作
    如果原有RDD的分区器和现有分区器一致,则不重分区,如果不一致,则相当于根据分区器生成一个
    新的ShuffledRDD.
    
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/partitionByTest/image/partitionby.jpg)   
    上图中方框代表RDD分区.通过新的分区策略将原来在不同分区的V1,V2数据都合并到一个分区.
    