package Demo;

import java.util.ArrayList;
import java.util.List;

public class MemoryLoadSimulator {

    // Method 1: Creates temporary objects
    public static void createTemporaryObjects(int count, int sizeInBytes) {
        for (int i = 0; i < count; i++) {
            byte[] data = new byte[sizeInBytes];
            data[0] = 1;
        }
    }

    // Method 2: Creates and retains objects
    public static List<byte[]> createRetainedObjects(int count, int sizeInBytes) {
        List<byte[]> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            byte[] data = new byte[sizeInBytes];
            data[0] = 1;
            list.add(data);
        }

        return list;
    }

    // Method 3: Used by your JUnit test
    public static List<byte[]> createObjectsForTest() {
        return createRetainedObjects(1000, 1024);
    }
}