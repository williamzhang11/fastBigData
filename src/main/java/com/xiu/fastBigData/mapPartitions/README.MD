# spark mapPartitions算子

    mapPartitions函数获取到每个分区的迭代器,在函数中通过这个分区整体的迭代器
    对整个分区的元素进行操作.而map是一个元素,一个元素的处理,因此mapPartitions有可能
    造成内存溢出
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/mapPartitions/image/mapPartitions.jpg)

    方框代表一个RDD分区.上图中,用户通过函数f(iter)=>iter.filter(>=3)进行过滤,大于
    等于3的数据保留.一个方块代表一个RDD分区,含有1,2,3的分区过滤只剩下3
    
    