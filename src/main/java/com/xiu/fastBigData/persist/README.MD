# persisit

persist函数对RDD进行缓存操作。数据缓存到哪里依据StorageLevel这个枚举类型确定。
DISK:硬盘
MEMPORY:内存
SER:数据是否进行序列化存储

![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/persist/image/persist.jpg)

上图中方框代表RDD分区。mem 代表存储在内存。数据最初全部存储在磁盘，通过 persist(MEMORY_AND_DISK) 
将数据缓存到内存，但是有的分区无法容纳在内存，将含有 V1、 V2、 V3 的RDD存储到磁盘，
将含有U1，U2的RDD仍旧存储在内存。


