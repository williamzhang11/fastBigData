# saveAsObjectFile
    saveAsObjectFile将分区中的每10个元素组成一个Array,然后将这个Array序列化，映射为（null,BytesWritable(Y)）
    的元素，写入HDFS为SequenceFile格式。
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/saveAsObjectFile/image/saveasobjectfile.jpg)

    上图中左侧方框代表RDD分区，右侧方框代表HDFS的Block。通过函数将RDD的每个分区存储为HDFS上的一个Block
    
