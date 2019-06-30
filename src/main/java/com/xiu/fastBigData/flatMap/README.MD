# spark flatMap算子
    
    将原来RDD中的每个元素通过函数f转换为新的元素,并将生成的RDD的每个集合中的元素
    合并为一个集合.
    
    
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/flatmap/image/flatmap.jpg)
    上图表示RDD的一个分区,进行flatMap函数操作,flatMap中传入的函数为:f:T->U,
    T和U可以是任意的数据类型.将分区中的数据通过自定义函数转换为新的数据.外部大方框
    是一个RDD分区,小方框代表一个集合.V1,V2,V3在一个集合作为RDD的数据项,可能存储为
    数组或其他容器,转换为V'1,V'2,V'3后,将原来的数组或容器结合拆散,拆散的数据形成RDD
    中数据.
    
    
    
    
    
    
    
    
    
    
    
    
    
