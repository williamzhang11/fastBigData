# spark join算子

    join 对2个需要连接的RDD进行cogroup操作,将相同key的数据能够存放到一个分区,
    在cogroup操作后形成的新RDD对每个key下元素进行笛卡儿积操作,返回的结果再展平
    ,对应key下的所有元组形成一个集合,最后返回RDD[(K,(V,W))]
    
    join函数本质是,通过cogroup算子先进行协同划分,再通过flatMapValues将合并数据打散
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/persist/image/persist.jpg)

    大方框代表RDD,小方框代表RDD中的分区.函数对相同key的元素,如V1为key做连接后结果
    为(V1,(1,1))和(V1,(1,2))
    
    leftOutJoin(左外连接)和rightOutJoin(右外连接)相当于在join的基础上先判断一侧的RDD元素是否为空
    如果为空，则填充为空.如果不为空，就将数据进行连接运算，返回结果
    
