package Day11.CompletableFuture.Task3;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    return 10 / 0;
                })
                .handle((result, ex) -> {

                    if (ex != null) {
                        System.out.println("Error occurred");
                        return 0;
                    }

                    return result;
                });

        System.out.println(future.join());
    }
}
