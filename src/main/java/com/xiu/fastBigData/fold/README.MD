# fold
    fold和reduce的原理相同,但是与reduce不同,相当于每个reduce时,迭代器取第一个元素
    是zeroValue.
    
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/fold/image/fold.jpg)

    上图中用户自定义函数进行fold运算,图中的一个方框代表一个RDD分区.