# lookup

    LookUp函数对k-v型RDD操作,返回指定key对应的元素形成seq.这个函数处理优化部分在于
    如果RDD包含分区器,则只会对应处理k所在分区,然后返回由(k,v)形成的seq.如果
    RDD不包含分区器,则需要对全RDD元素进行暴力扫面处理,搜索指定k对应的元素.
![image](https://github.com/williamzhang11/fastTech/blob/master/src/main/java/com/xiu/fastBigData/persist/image/persist.jpg)

    上图的左侧方框代表RDD分区,右侧方框代表seq,最后结果返回到Driver所在节点应用中.