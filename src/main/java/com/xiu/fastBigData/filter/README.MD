# spark filter算子

    filter函数功能是对元素进行过滤,对每个元素应用函数f,返回值为true的元素在RDD中
    保留,返回值为false的元素被过滤掉.内部实现相当于生成FilteredRDD(this，sc.clean(f))
    
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/filter/image/filter.jpg)

    上图中每个方框代表一个RDD分区,T可以是任意类型.通过用户自定义的过滤函数f,对每个
    数据项操作,将满足条件,返回结果为true的数据项保留.如,过滤掉V2和V3保留V,为区分命名
    V'1