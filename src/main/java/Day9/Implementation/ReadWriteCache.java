package Day9.Implementation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCache {

    private final Map<String, String> data = new HashMap<>();
    private final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();

    public void put(String key, String value) {
        lock.writeLock().lock();

        try {
            data.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String get(String key) {
        lock.readLock().lock();

        try {
            return data.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void remove(String key) {
        lock.writeLock().lock();

        try {
            data.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
