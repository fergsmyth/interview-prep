package javaknowledge.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class StreamTest {

    public static void main(String[] args) {
//        nullableStreamsAndCounts();
//        takenDropFilters();
        StreamTest streamTest = new StreamTest();
//        streamTest.simpleStream();
//        streamTest.streamTypes();
//        streamTest.streamAreLaziness();
//        streamTest.operationOrderMatters();
        streamTest.streamsAreDeadLongLiveStreams();
    }

    private void streamsAreDeadLongLiveStreams() {

    }

    private static void nullableStreamsAndCounts() {
        long count = Stream.ofNullable(null).count();
        System.out.println(count); // 0
    }

    private static void takenDropFilters() {
        var dropFiltered = Stream.of(1, 2, 3, 4, 5).dropWhile(n -> n < 3).collect(Collectors.toList());
        System.out.println(dropFiltered);

        var takenFiltered = Stream.of(10, 20, 30, 40).takeWhile(n -> n < 30).collect(Collectors.toList());
        System.out.println(takenFiltered);
    }

    public void simpleStream(){
        var list = List.of("a1", "a2", "b1", "c2", "c1");
        list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    public void streamTypes(){
        Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
        Stream.of("a1","b1","c1").findFirst().ifPresent(System.out::println);

        System.out.println(IntStream.range(1,10).sum());
//        LongStream, DoubleStream

        Arrays.stream(new double[]{1.0, 2.0, 3.0})
                .map(n -> 2 * n - 1)
                .average()
                .ifPresent(System.out::println);

        DoubleStream.of(1.0,2.0,3.0)
                .min()
                .ifPresent(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToDouble(Double::valueOf)
                .map(n-> 2 * n-1)
                .max()
                .ifPresent(System.out::println);

        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(1,4)
                .mapToObj(i -> "string"+i)
                .forEach(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "Int" + i)
                .forEach(System.out::println);
    }

    /** Intermediate steps will not execute without a terminating step */
    public void streamAreLaziness(){

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                   System.out.println(s);
                   return true;
                });

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                   System.out.println(s);
                   return true;
                }).findFirst();

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                   System.out.println("filter " + s);
                   return true;
                })
                .forEach(s -> System.out.println("foreach " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("Upper " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("Any match " + s);
                    return s.startsWith("A");
                });

    }

    /**
     * Correct operation ordering can reduce processing
     * as an element is processed entirely before the next element.
     */
    public void operationOrderMatters(){
        System.out.println("Bad ordering");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("Upper " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("Filter " + s);
                    return s.startsWith("A");
                })
        .forEach(System.out::println);

        System.out.println("Good ordering");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("Filter " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("Upper " + s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

        System.out.println("Bad ordering with sort");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.println("Sorting " + s1 + " and " + s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("Filter " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("Upper " + s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

        System.out.println("Good ordering with sort");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("Filter " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.println("Sorting " + s1 + " and " + s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("Upper " + s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);
    }

}
