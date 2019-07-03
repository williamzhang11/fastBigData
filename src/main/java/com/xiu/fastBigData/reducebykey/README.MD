# reduceByKey

reduceBykey是比combineBykey更简单的一种情况，只是2个值合并成一个值

![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/reducebykey/image/reducebykey.jpg)

上图中方框代表RDD分区，通过用户自定义函数（A,B）=>(A+B)函数，将相同key数据（V1,2）和（V1,1）的value相加运算
，结果为（V1,3）