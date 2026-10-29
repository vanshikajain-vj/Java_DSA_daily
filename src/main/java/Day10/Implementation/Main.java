package Day10.Implementation;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadFactory() {
                    int count = 1;

                    public Thread newThread(Runnable task) {
                        return new Thread(task, "Worker-" + count++);
                    }
                }
        );

        for (int i = 1; i <= 6; i++) {
            int task = i;

            executor.execute(() ->
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " executing task " + task
                    )
            );
        }
        executor.shutdown();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");

            executor.shutdown();

            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }

            System.out.println("Shutdown complete");
        }));

        for (int i = 1; i <= 3; i++) {
            int task = i;

            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Task " + task + " completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}
