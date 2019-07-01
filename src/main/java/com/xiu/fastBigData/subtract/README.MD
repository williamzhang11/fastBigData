# subtract

    subtract相当于进行集合差操作。RDD1去除RDD1和RDD2交集中的所有元素。
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/filter/image/filter.jpg)
    
    上图中左侧大方框代表2个RDD,大方框内的小方框代表RDD的分区，右侧大方框代表合并后的RDD,大方框的小方框
    代表分区。V1在2个RDD中均有，根据差集运算规则，新RDD不保留，V2在第一个RDD有，第二个RDD没有。则在新的
    RDD元素中包含V2