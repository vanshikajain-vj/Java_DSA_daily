package Day9.Ques;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch ready = new CountDownLatch(5);
        CountDownLatch start = new CountDownLatch(1);

        for (int i = 1; i <= 5; i++) {
            int worker = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker " + worker + " is ready");

                    ready.countDown();
                    start.await();

                    System.out.println("Worker " + worker + " started working");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        ready.await();
        System.out.println("All workers are ready. Start!");
        start.countDown();

        //2.Throttle access to a limited resource using Semaphore
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 5; i++) {
            int id = i;

            new Thread(() -> {
                try {
                    semaphore.acquire();

                    try {
                        System.out.println("Thread " + id + " is using resource");

                        Thread.sleep(2000);

                        System.out.println("Thread " + id + " finished");
                    } finally {
                        semaphore.release();
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        //3.Demonstrate tryLock with timeout to avoid permanent deadlock
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();

            try {
                System.out.println("Thread 1 got lock");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Thread 2 got lock");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("Thread 2 timeout!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        t2.start();
    }
}

