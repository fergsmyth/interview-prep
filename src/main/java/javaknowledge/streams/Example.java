package javaknowledge.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Integer> collect = List.of(3, 7, 5, 20, 3, 30, 4, 40, 5, 50)
                .stream()
                .skip(2)
                .map(n -> n * 3)
                .filter(n -> n % 2 == 0)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
