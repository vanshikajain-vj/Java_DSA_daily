package Day5.Implementation;


public class Main {
    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "Apple");
        cache.put(2, "Banana");
        cache.put(3, "Mango");

        cache.get(1);
        cache.put(4, "Orange");
        System.out.println(cache);
    }
}

