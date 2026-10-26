package Day5;
import Day5.Implementation.LRUCache;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void testCacheEviction() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "Apple");
        cache.put(2, "Banana");

        cache.put(3, "Mango"); // Key 1 should be removed

        assertEquals(2, cache.size());
        assertFalse(cache.containsKey(1));
        assertTrue(cache.containsKey(2));
        assertTrue(cache.containsKey(3));
    }
}
