# cache

cache将RDD元素从磁盘缓存到内存。相当于persisit功能
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/cache/image/cache.jpg)

上图中每个方框代表一个RDD分区，左侧相当于数据分区都存储在磁盘，通过cache算子将数据缓存在内存。
