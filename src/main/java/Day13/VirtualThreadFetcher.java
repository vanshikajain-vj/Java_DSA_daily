package Day13;
import java.util.concurrent.ExecutorService;

public class VirtualThreadFetcher {

    public static void main(String[] args) {

        try (ExecutorService executor =
                     java.util.concurrent.Executors
                             .newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 5; i++) {

                int id = i;

                executor.submit(() -> {
                    System.out.println(
                            "Fetching data for API " + id +
                                    " using " + Thread.currentThread()
                    );
                });
            }
        }
    }
}
