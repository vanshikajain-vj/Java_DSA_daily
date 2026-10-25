package Day3.Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String str="vanshiiikaaa";
        String result = str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(result);

        //2.Check if two lists contain at least one common element
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5);
        boolean answer= list1.stream()
                .anyMatch(list2::contains);
        System.out.println(answer);

        //3.Find duplicate elements with their count in a list

        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4);

        Map<Integer,Long> res=numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .collect(Collectors.toMap(
                        entry->entry.getKey(),
                        entry->entry.getValue()
                ));
        System.out.println(res);

        //4.Concatenate multiple string lists into a single sorted list
        List<String> list3 = List.of("banana", "apple");
        List<String> list4 = List.of("mango", "cherry");

        List<String> concated= Stream.concat(list3.stream(),
                list4.stream())
                .sorted()
                .toList();
        System.out.println(concated);

        //5.Find strings of length greater than 3 that start and end with the same letter
        List<String> words = List.of("level", "hello", "world", "radar", "java");
        List<String> filtered= words.stream()
                .filter(word->word.length()>3)
                .filter(word -> word.charAt(0) ==
                        word.charAt(word.length() - 1))
                .collect(Collectors.toList());
        System.out.println(filtered);














    }

}
