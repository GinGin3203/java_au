import java.util.LinkedHashMap;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return (this.size() > this.capacity);
    }

    public LRULinkedHashMap(int capacity) {
        super(capacity + 1,1.0f,true);
        this.capacity = capacity;
    }

    // get and put are already implemented in LinkedHashMap
}
