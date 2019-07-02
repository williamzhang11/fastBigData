# foreach
action算子，触发sparkContext进行提交runjob操作，触发RDD DAG执行
foreach对RDD中每个元素都应用f函数操作，不反回RDD和Array，而是返回Uint
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/flatmap/image/flatmap.jpg)

上图中表示foreach算子通过用户自定义函数对每个数据项进行操作。