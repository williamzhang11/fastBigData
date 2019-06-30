# Spark Map算子
    将原来RDD的每个数据项通过map中的用户自定义函数f映射转变为一个新的元素.
    源码种map算子相当于初始化一个RDD
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/map/image/map.jpg)

    上图种每个方框代表一个RDD分区,左侧的分区经过用户自定义函数f:T->U映射为
    右侧的新RDD分区.但是实际只有等Action算子触发后,这个f函数才会和其他函数
    在一个stage中数据进行运算
    上图中的第一个分区,数据记录V1输入f,通过f转换输出为转换后的分区中的数据记录v'1