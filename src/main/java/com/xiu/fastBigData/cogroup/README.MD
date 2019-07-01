# cogroup spark算子
    cogroup函数将2个RDD进行协同划分,对在2个RDD中的k-v类型的元素,每个RDD相同key的元素
    分布聚合为一个集合,并且返回2个RDD中对应key的元素集合的迭代器
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/persist/image/persist.jpg)

上图中大方框代表RDD,大方框内的小方框代表RDD中的分区.将RDD1中的数据(U1,1),(U1,2)
和RDD2中的数据(U1,2)合并为(U1,((1,2),(2)))
