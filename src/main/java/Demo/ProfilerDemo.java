package Demo;
import java.util.List;

public class ProfilerDemo {

    public static void main(String[] args) {

        MemoryProfiler.showMemory();

        MemoryProfiler.measure("Temporary Objects", () ->
                MemoryLoadSimulator.createTemporaryObjects(20000, 1024)
        );

        List<byte[]> list = MemoryLoadSimulator.createRetainedObjects(20000, 1024);

        System.out.println("Retained objects: " + list.size());

        MemoryProfiler.showMemory();
    }
}