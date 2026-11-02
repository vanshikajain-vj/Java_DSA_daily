package Day9.Implementation;


public class Main {

    public static void main(String[] args) {

        ReadWriteCache cache = new ReadWriteCache();

        cache.put("name", "Vijju");
        cache.put("language", "Java");

        System.out.println(cache.get("name"));
        System.out.println(cache.get("language"));

        cache.remove("name");

        System.out.println(cache.get("name")); // null
    }
}


