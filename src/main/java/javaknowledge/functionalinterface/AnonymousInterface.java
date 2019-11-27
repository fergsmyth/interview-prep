package javaknowledge;

interface InterfaceToOverride {
    String singleMethod();
}

public class AnonymousInterface {
    public static void main(String[] args) {
        InterfaceToOverride override = () -> "test";
        System.out.println(override.singleMethod());
    }
}
