package Demo;

public class MemoryProfiler {

    public static void showMemory() {
        boolean task ;

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();

        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total Memory: " + totalMemory / 1024 / 1024 + " MB");
        System.out.println("Free Memory: " + freeMemory / 1024 / 1024 + " MB");
        System.out.println("Used Memory: " + usedMemory / 1024 / 1024 + " MB");
        System.out.println("Max Memory: " + maxMemory / 1024 / 1024 + " MB");
    }

    // Measure memory before and after a task
    public static void measure(String taskName, Runnable task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        Runtime runtime = Runtime.getRuntime();

        long before = runtime.totalMemory() - runtime.freeMemory();

        task.run();

        long after = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("\nTask: " + taskName);
        System.out.println("Heap before: " + before / 1024 / 1024 + " MB");
        System.out.println("Heap after: " + after / 1024 / 1024 + " MB");
        System.out.println("Heap delta: " + (after - before) + " bytes");
    }
}
