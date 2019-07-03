# collectAsMap
    
    collectAsMap对(k,v)型RDD数据返回一个单机HashMap.对于重复k的RDD元素,后面元素覆盖
    前面的元素.
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/collect/image/collect.jpg)

    上图中左侧方框代表RDD分区,右侧方框代表单机数组.数据通过collectAsMap函数返回给
    Driver程序计算结果,结果以HahsMap形式存储.