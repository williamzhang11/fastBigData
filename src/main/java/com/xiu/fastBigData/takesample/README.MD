# takeSample
    takeSample和sample函数是一个原理，但是不适用相对比例采样，而是按设定的
    采样个数进行采样，同时返回结果不再是RDD，而是相当于对采样后的数据进行collect()
    返回结果的集合为数组。
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/takesample/image/takesample.jpg)

    上图左侧的方框代表分布式的各个节点上的分区，右侧方框代表单机上返回的结果数组。通过takeSample
    对数据采样，设置为采样一份数据，返回结果为V1。
    