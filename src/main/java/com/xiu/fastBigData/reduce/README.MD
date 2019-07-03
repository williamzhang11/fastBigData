# reduce
    reduce函数相当于对RDD中的元素进行reduceLeft函数的操作。
    
    
![image](https://github.com/williamzhang11/fastBigData/blob/master/src/main/java/com/xiu/fastBigData/reduce/image/reduce.jpg)

    上图中方框代表一个RDD分区，通过用户自定函数f将数据进行reduce运算。最后返回结果为V1@[1]V2U！@U2@U3@U4，12
    
    reduceLeft先对2个元素<k,v>进行reduce函数操作,然后将结果和迭代器取出下一个元素<k,v>
    进行reduce函数操作,直至迭代器遍历完所有元素,得到最后结果.先对每个分区中的所有元素
    <K,V>的集合分别进行reduceLeft.每个分区形成的结果相当于一个元素<k,v>最对这个结果
    集合进行reduceleft操作