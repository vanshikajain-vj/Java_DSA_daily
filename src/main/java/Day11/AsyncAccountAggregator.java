package Day11;


import java.util.concurrent.CompletableFuture;

public class AsyncAccountAggregator {

    public static CompletableFuture<String> getAccount() {
        return CompletableFuture.supplyAsync(() -> {
            return "Account Details";
        });
    }

    public static CompletableFuture<Double> getBalance() {
        return CompletableFuture.supplyAsync(() -> {
            return 5000.0;
        });
    }

    public static CompletableFuture<String> getTransactions() {
        return CompletableFuture.supplyAsync(() -> {
            return "Transaction History";
        });
    }

    public static void main(String[] args) {

        CompletableFuture<String> account = getAccount();

        CompletableFuture<Double> balance = getBalance();

        CompletableFuture<String> transactions = getTransactions();

        CompletableFuture<Void> result = CompletableFuture.allOf(
                account, balance, transactions
        );

        result.thenRun(() -> {
            System.out.println(account.join());
            System.out.println(balance.join());
            System.out.println(transactions.join());
        }).join();
    }
}

