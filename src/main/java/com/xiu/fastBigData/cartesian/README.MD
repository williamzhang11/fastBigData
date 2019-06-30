# Spark cartesian算子
    对2个RDD内的所有元素进行笛卡儿积操作.操作后,内部实现返回CartesianRDD.
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/cartesian/image/cartesian.jpg)
左侧大方框代表两个 RDD，大方框内的小方框代表 RDD 的分区。右侧大方框代表合并后的 RDD，大方框内的小方框代表分区
    V1和另一个RDD中的W1、W2、Q5进行笛卡尔积运算形成(V1,W1)、(V1,W2)、(V1,Q5)