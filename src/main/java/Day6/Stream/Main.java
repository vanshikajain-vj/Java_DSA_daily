package Day6.Stream;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class EmployeeDTO {
    String name;

    EmployeeDTO(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class Main {

    <T> List<T> filter(List<T> list, Predicate<T> condition) {
        return list.stream()
                .filter(condition)
                .toList();
    }

    public static void main(String[] args) {
        Main obj = new Main();

        //1.Filter items using generic Predicate filter utility
        List<Integer> numbers = List.of(10, 15, 20, 25, 30);
        List<Integer> result = obj.filter(numbers, n -> n > 20);
        System.out.println(result);

        //2.Map domain entities to DTOs using a generic Function
        List<Employee> employees = List.of(
                new Employee("Amit"),
                new Employee("Neha")
        );
        Function<Employee, EmployeeDTO> convert =
                e -> new EmployeeDTO(e.name);

        List<EmployeeDTO> res = employees.stream()
                .map(convert)
                .toList();

        System.out.println(res);

        //3.Wrap a checked exception into a custom runtime exception inside Stream.map()
        List<String> names = List.of("A", "B");
        List<String> result1 = names.stream()
                .map(n -> {
                    try {
                        if (n.equals("Vijju")) {
                            throw new IOException("Error");
                        }
                        return n;
                    } catch (IOException e) {
                        throw new MyRuntimeException(e);
                    }
                })
                .toList();

        System.out.println(result1);

        //4.Safely extract an Optional value without calling get() directly
        Optional<String> name=Optional.of("Vanshu");
        String ans=name.orElse("Unknown");
        System.out.println(ans);

        //5.Transform List<Optional<T>> into List<T>, unwrapping present values
        List<Optional<String>> list = Arrays.asList(
                Optional.of("Java"),
                Optional.empty(),
                Optional.of("Spring"),
                Optional.of("SQL")
        );
        List<String> result2 = list.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        System.out.println(result2);









    }






}