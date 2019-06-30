# Spark glom算子
    glom函数将每个分区形成一个数组,内部实现是返回的GlommedRDD.下图中每个方框
    代表一个RDD分区.,该图表示含有V1,V2,V3的分区通过函数glom形成一数组
    Array[(V1),(V2),(V3)]
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/glom/image/glom.jpg)