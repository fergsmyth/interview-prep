package javaknowledge.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        streamSkipMapFilterLimitCollect();
        groupBy();
    }

    private static void streamSkipMapFilterLimitCollect() {
        List<Integer> collect = List.of(3, 7, 5, 20, 3, 30, 4, 40, 5, 50)
                .stream()
                .skip(2)
                .map(n -> n * 3)
                .filter(n -> n % 2 == 0)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void groupBy(){
        List<Character> characters = List.of('a', 'b', 'c', 'd', 'a', 'a', 'c', 'b');
        Map<Character, Long> characterLongMap = characters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterLongMap);
    }
}
