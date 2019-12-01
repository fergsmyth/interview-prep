package javaknowledge.strings;

public class StringTest {

    public static void main(String[] args) {

        boolean isBlank = " ".isBlank();
        System.out.println(isBlank);

        String stripped = " Foo Bar ".strip();
        System.out.println(stripped);

        String stripTrailing = " Foo Bar ".stripTrailing();
        System.out.println(stripTrailing);

        String stripLeading = " Foo Bar ".stripLeading();
        System.out.println(stripLeading);

        String repeated = "Rep".repeat(3);
        System.out.println(repeated);

        long lineCount = "A\nB\nC".lines().count();
        System.out.println(lineCount);

    }

}
