package Day8;
import Day8.Stream.CustomBoundedQueue;
import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomBoundedQueueTest {

    @Test
    void shouldNotLoseItemsOrDeadlock() throws Exception {
        CustomBoundedQueue<Integer> queue = new CustomBoundedQueue<>(5);
        AtomicInteger consumed = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<?> producer = executor.submit(() -> {
                try {
                    for (int i = 0; i < 1000; i++) {
                        queue.put(i);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            });

            Future<?> consumer = executor.submit(() -> {
                try {
                    for (int i = 0; i < 1000; i++) {
                        queue.take();
                        consumed.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            });

            producer.get(5, TimeUnit.SECONDS);
            consumer.get(5, TimeUnit.SECONDS);

            assertEquals(1000, consumed.get());

        } finally {
            executor.shutdownNow();
        }
    }
}
