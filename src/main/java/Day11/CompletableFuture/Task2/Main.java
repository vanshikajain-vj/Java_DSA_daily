package Day11.CompletableFuture.Task2;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "vanshika")

                .thenApply(name -> name.toUpperCase())

                .thenApply(name -> "Hello " + name);

        future.thenAccept(result -> {
            System.out.println(result);
        }).join();
    }
}