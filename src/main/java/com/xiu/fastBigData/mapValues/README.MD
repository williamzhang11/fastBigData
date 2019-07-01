# mapValues
    针对k-v型数据中的value进行map操作，而不对key进行处理
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/persist/image/persist.jpg)

    上图中方框代表RDD分区。a=>a+2代表（V1,1）这样的k-v数据对，数据只对v中1进行加2操作，返回3.