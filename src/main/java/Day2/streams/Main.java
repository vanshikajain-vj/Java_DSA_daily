package Day2.streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Order{
    List<String> items;
    public Order(List<String> items){
        this.items=items;
    }

    public List<String> getItems() {
        return items;
    }
}

class Employee{
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class User{
    String name;
    int age;
    boolean active;

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }
}

public class Main {
    static void main() {
        List<Employee> employee=Arrays.asList(
                new Employee("Alice",90000),
                new Employee("Vanshika",800000),
                new Employee("Keshav",67000),
                new Employee("Shradha",56000)
        );

        List<Order> orders = List.of(
                new Order(List.of("Laptop", "Mouse")),
                new Order(List.of("Keyboard", "Monitor")),
                new Order(List.of("Phone", "Charger"))
        );


        Map<Boolean, List<Employee>> result=employee.stream()
                .collect(Collectors.partitioningBy(e->e.getSalary()>80000));
        System.out.println(result);

        //2.find 2nd highest no in an integer list
        List<Integer> numbers=List.of(1,2,3,4,5,6);
        int secondHighest=numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println(secondHighest);

        //3.first non repeating charcter in a string
        String str= "sswiss";
        Character result1= str.chars() //intStream of char
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(entry->entry.getKey())
                .findFirst()
                .orElse(null);
        System.out.println(result1);

        //4.flatmap a list of orders to extract all item names
        List<String> itemNames = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toList());

        System.out.println(itemNames);

        //5.find avg age of all active users
        List<User> users = List.of(
                new User("Aman", 20, true),
                new User("Priya", 30, true),
                new User("Rahul", 40, false),
                new User("Neha", 25, true)
        );

        double averagAge=users.stream()
                .filter(user->user.isActive())
                .mapToInt(user->user.getAge())
                .average()
                .orElse(0);
       System.out.println( averagAge);


    }
}
