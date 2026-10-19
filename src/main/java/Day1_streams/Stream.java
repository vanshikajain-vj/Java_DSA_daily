package Day1_streams;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.Arrays.*;

class Employee{
    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }

    public  String getName(){
        return name;
    }

    public double getSalary(){
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



public class Stream {
    static void main() {
        List<Integer> list=List.of(1,2,3,4,5,6,6);
        //1.filterv even no and print square
        List<Integer> EvenNumberSquare= list.stream()
                .filter(n->n%2==0)
                .map(n -> n*n)
                .toList();
        System.out.println(EvenNumberSquare);

        //2.find max & min in array
        int[] numbers={10,20,30,40,50,60};
        int max= list.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
        System.out.println(max);

        //3.count freq of each word in a string
        String str="Today is a good day Be positive Vanshika";
        Map<String,Long> freq= stream(str.split(" "))
                .collect(Collectors.groupingBy(
                        word->word,
                        Collectors.counting()
                ));
        System.out.println(freq);

        //4.convert alist of strings into uppercase comma sperated string
        List<String> words=List.of("apple","cherry","kiwi","grapes","chiku");
        String result=words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(result);

        //5.sort a list of employes objects by salary descending then name ascending
        List<Employee> employee= List.of(
                new Employee("Vanshika",50000),
                new Employee("Keshav",400000),
                new Employee("Aman",50000),
                new Employee("Diya",70000)
        );

        List<Employee> sortedEmployee=employee.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                .thenComparing(Employee::getName)
                )
                .toList();
        System.out.println(sortedEmployee);
    }
}
