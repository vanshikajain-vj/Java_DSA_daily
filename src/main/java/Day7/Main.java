package Day7;

import java.util.*;
import java.util.stream.Collectors;

class Order {
    String category;
    String status;
    double amount;

    Order(String category, String status, double amount) {
        this.category = category;
        this.status = status;
        this.amount = amount;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Electronics", "COMPLETED", 1000),
                new Order("Electronics", "PENDING", 500),
                new Order("Electronics", "COMPLETED", 2000),
                new Order("Clothing", "COMPLETED", 800),
                new Order("Clothing", "PENDING", 300)
        );

        Map<String, Map<String, Double>> result = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.category,
                        Collectors.groupingBy(
                                order -> order.status,
                                Collectors.summingDouble(order -> order.amount)
                        )
                ));

        System.out.println(result);
    }
}
