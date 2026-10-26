package Day8.Implementation;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    static int count1 = 0;
    static volatile int count2 = 0;

    public static void main(String[] args) throws InterruptedException {

        // 1. AtomicInteger with parallel stream
        AtomicInteger counter = new AtomicInteger(0);

        IntStream.range(0, 1000)
                .parallel()
                .forEach(n -> counter.incrementAndGet());

        System.out.println("Atomic counter: " + counter.get());

        // 2. Normal int vs volatile int
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count1++;
                count2++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                count1++;
                count2++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Normal int: " + count1);
        System.out.println("Volatile int: " + count2);
        System.out.println("Expected: 200000");

        //3.Implement producer-consumer using wait() and notify()
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        //4. Use Thread.sleep and interrupt() to handle graceful thread termination
        Worker worker = new Worker();

        worker.start();

        Thread.sleep(3000);
        System.out.println("Main thread requests worker to stop.");
        worker.interrupt();
        worker.join();

    }
}