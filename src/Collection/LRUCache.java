package Collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int maxEntries;

    public LRUCache(int maxEntries) {
        super(16,0.75f,true);
        this.maxEntries = maxEntries;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
       //当超出 容量限制时候，移除最久没有被访问的元素
        return size()>maxEntries;
    }

}
