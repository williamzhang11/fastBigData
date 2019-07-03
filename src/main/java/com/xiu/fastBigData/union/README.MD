# union算子
	使用union函数时需要保证2个RDD元素的数据类型相同，返回的RDD数据类型和被合并RDD元素数据类型相同，并不进行去重操作
	保存所有元素，如果向去重可以 使用distinct()。
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/union/image/union.jpg)
新的RDD将旧的RDD中的partition数据原样搬过来
新的RDD的partition数目是旧的2个RDD的partition数目总和
