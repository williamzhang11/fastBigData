# Spark groupBy算子
    groupBy算子,将元素通过函数生成相应的key,数据转化为key-value格式,之后将key相同
    的元素分为一组.函数实现如下:
    1)将
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/groupby/image/groupBy.jpg)
    
    上图中方框代表一个RDD分区,相同的key的元素合并到一个组.如V1和V2合并为V,Value为
    V1,V2.形成V,Seq(V1,V2)
    
    groupBy与groupByKey的区别是,groupBy可以指定key