package Collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public class LinkedHashMapTest {
    public static void main(String [] args){
        //默认情况下，是按照插入有序的
        Map<String,Integer> map= new LinkedHashMap();
        map.put("c",100);
        map.put("d",200);
        map.put("a",500);
        map.put("d",300);
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        /**
         *
         *
         键是按照c d a的顺序 插入的，修改 d的值 不会修改顺序
         c 100
         d 300
         a 500
         */


        //接下来 演示 按照 访问有序的例子：
        System.out.println("************************");
        //每次访问 都会将键值移动到末尾---比如LRU缓存算法
        /**
         * LRU  ---Least Recently Used
         * LinkedHashMap可以用于进行缓存操作，比如缓存用户的基本信息
         * ，键是用户id,值是用户信息，所有用户的信息保存在数据库里面
         * 部分活跃的信息 保存到缓存里面
         *
         * 一般而言 ，缓存容量有限，不能无限的进行存储，
         * 如果缓存满了，就需要一些策略将一些老的数据进行清空---这个策略一般称之为替换
         * LRU是一种流行的替换算法
         *  它的意思是最近刚被使用的很快再次被使用的可能性最低，
         *  而最近没有被访问到的资源再次被访问到的几率最低，所以被优先清理
         *  使用LinkedHashMap可以很方便的实现LRU
         *  默认情况下，LinkedHashMap对容量没有限制，它比较容易做的是他有一个removeEldesEntry方法，
         *
         *  添加这个元素到LinkedHashMap后，LinkedHashMap会调用这个方法
         *  ，传递的参数是最久没有被访问的键值对，如果这个
         *  方法返回true,则这个最久的键值对就会被删除
         *  子类重写可以实现这个方法
         */
        Map<String,Integer> accessMap=new LinkedHashMap<>(16,0.75f,true);
        accessMap.put("c",100);
        accessMap.put("d",200);
        accessMap.put("a",500);
        accessMap.get("c");
        accessMap.put("d",300);//更新
        for (Map.Entry<String,Integer> entry:accessMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        //测试LRU缓存 基于LinkedHashMap实现
        LRUCache<String,Object> cache=new LRUCache<>(3);
        cache.put("a","aaaa");
        cache.put("b","bbbb");
        cache.put("c","xxxx");
        cache.get("a");
        cache.put("d","call");
        System.out.println(cache);//将很久 没有被访问 超出容量范围的 a,b移除 {c=xxxx, a=aaaa, d=call}

        //###############
        Map<String,Integer> niMap=new LinkedHashMap<>(16,0.75f);
        niMap.put("hello",1);
        niMap.put("position",23);

    }
}
