# sample
    sample将RDD这个集合内的元素进行采样，获取所有元素的子元素。用户可以设定是否有放回的抽样
    百分比，随机种子，进而决定采样方式。
    
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/sample/image/sample.jpg)

    上图中的每个方框是一个RDD分区。通过sample函数，采样50%数据，V1，V2,U1,U2,U3,U4采样出数据V1和U1,U2
    形成新的RDD. 
    
    withReplacement：表示抽出样本后是否在放回去，true表示会放回去，这也就意味着抽出的样本可能有重复
    
