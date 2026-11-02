package Day5.stream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class Main {
    public static void main(String[] args) {

        //1.Convert Map into a List of keys sorted by value descending
        Map<String, Integer> map = Map.of(
                "Apple", 30,
                "Banana", 50,
                "Mango", 40
        );

        List<String> result = map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(e -> e.getKey())
                .toList();

        System.out.println(result);

        //2Merge two maps and sum duplicate values using Map.merge()
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Apple", 10);
        map1.put("Banana", 20);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Apple", 30);
        map2.put("Mango", 40);

        map2.forEach((key, value) ->
                map1.merge(key, value, Integer::sum)
        );

        System.out.println(map1);

        //3.Count character occurrences using chars() and Collectors.toMap()
        String str = "banana";

        Map<Character, Long> res = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> Long.valueOf(1),
                        Long::sum,
                        LinkedHashMap::new
                ));
        System.out.println(res);

        //4.Find the top 3 highest-salaried employees in each department
        List<Employee> employees = List.of(
                new Employee("Amit", "IT", 80000),
                new Employee("Neha", "IT", 95000),
                new Employee("Raj", "IT", 90000),
                new Employee("Priya", "IT", 85000),
                new Employee("John", "HR", 70000),
                new Employee("Sara", "HR", 90000),
                new Employee("Mike", "HR", 80000),
                new Employee("Anu", "HR", 75000)
        );

        Map<String, List<Employee>> topEmployeesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                                        .limit(3)
                                        .toList()
                        )
                ));
        System.out.println(topEmployeesByDept);

        //5.Collect stream results into a TreeMap for natural ordering
        List<String> words = List.of(
                "Mango", "Apple", "Banana", "Orange"
        );

        TreeMap<String, Integer> ans= words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        String::length,
                        (a, b) -> a,
                        TreeMap::new
                ));

        System.out.println(ans);









    }
}
