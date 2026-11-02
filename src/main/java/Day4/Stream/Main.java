package Day4.Stream;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    long timestamp;
    double amount;
    Transaction(long timestamp, double amount) {
        this.timestamp = timestamp;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return timestamp + " : " + amount;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction(200, 500),
                new Transaction(100, 300),
                new Transaction(100, 100),
                new Transaction(200, 200)
        );

        List<Transaction> result = transactions.stream()
                .sorted(Comparator.comparingLong((Transaction t) -> t.timestamp)
                        .thenComparingDouble(t -> t.amount))
                .toList();

        result.forEach(System.out::println);

        //2.Grp string by their len
        List<String> words = List.of("cat", "apple", "dog", "hi", "mango");
        Map<Integer,List<String>> res= words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(res);

        //3.Find the sum of all elements in a nested list using flatMap
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6)
        );
        int sum=nestedList.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        //4.Filter out null and blank strings
        List<String> strings = Arrays.asList("Hello", null, "World", "", "Java", "  ", "Stream");
        List<String> filteredStrings = strings.stream()
                .filter(Objects::nonNull)
                .filter(word->!word.isBlank())
                .toList();
        System.out.println(filteredStrings);

        //5.Create an unmodifiable list using Collections.unmodifiableList() and List.of()
        List<String> list1 = new ArrayList<>(
                Arrays.asList("Java", "Python", "C++")
        );

        List<String> result1 = Collections.unmodifiableList(list1);
        List<String> result2 = List.of("Java", "Python", "C++");
        System.out.println(result1);
        System.out.println(result2);




    }
}
