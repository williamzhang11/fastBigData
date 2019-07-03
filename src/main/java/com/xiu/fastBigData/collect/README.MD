# collect

    collect将分布式的RDD返回为一个单机的scala Array数组。在这个数组上运用scala的函数式操作
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/collect/image/collect.jpg)

    左侧方框代表RDD分区，右侧方框代表单机内存中数组。通过函数操作，将结果返回到Driver程序所在的节点
    以数组形式存储。