package Day5.Implementation;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int cap;

    public LRUCache(int cap) {
        super(16, 0.75f, true);
        this.cap = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cap;
    }
}
