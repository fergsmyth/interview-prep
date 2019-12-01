package javaknowledge.optionals;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        Object foo = Optional.of("foo").orElseThrow();
        System.out.println(foo);

        // Throws no such element
        // Optional.ofNullable(null).orElseThrow();

        // Convert optionals to streams.
        Optional.of("One streamy foo").stream().forEach(System.out::println);

        // Provide optionals as fallbacks for empty optionals.
        Optional.ofNullable(null).or(() -> Optional.of("fallback")).get();

    }

}
