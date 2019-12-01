package javaknowledge.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        long count = Stream.ofNullable(null).count();
        System.out.println(count); // 0

        var dropFiltered = Stream.of(1, 2, 3, 4, 5).dropWhile(n -> n < 3).collect(Collectors.toList());
        System.out.println(dropFiltered);

        var takenFiltered = Stream.of(10,20,30,40).takeWhile(n -> n > 20).collect(Collectors.toList());
        System.out.println(takenFiltered);

    }
}
