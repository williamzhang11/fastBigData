# aggregate

    aggregate先对每个分区的所有元素进行agregate操作,再对分区结果进行fold
    aggregate与fold和reduce的不同之处在于,aggregate相当于采用归并的方式进行数据聚集
    这种聚集是并行化的.而再fold和reduce函数的运算过程中,每个分区中需要进行串行处理,
    每个分区串行计算完结果,结果再按之前的方式进行聚集,并返回最终聚集结果.
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/fold/image/fold.jpg)
````
public <U> U aggregate(U zeroValue, Function2<U, T, U> seqOp, Function2<U, U, U> combOp)

````
上图中,通过用户自定义函数对RDD进行aggregate的聚集操作,图中每个方框代表一个RDD.
seqOp：针对每个分区（节点）的操作函数

combOp：在seqOp对每个分区操作完成之后，将每个分区的结果进行整合，从而求出最后的结果
    