package Day10.Implementation.SubmitCallableTask;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executor.submit(() -> 10 + 20);
        Future<Integer> f2 = executor.submit(() -> 30 + 40);

        System.out.println(f1.get());
        System.out.println(f2.get());

        executor.shutdown();
    }
}