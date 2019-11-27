package javaknowledge.functionalinterface;

@FunctionalInterface
interface InterfaceToOverride {
    String singleMethod();

    default String defaultMethod(){
        return getClass().getName();
    }

}

public class AnonymousInterface {

    public static void main(String[] args) {
        InterfaceToOverride oneline = oneline();

        System.out.println(oneline.singleMethod());
        System.out.println(oneline.defaultMethod());

        InterfaceToOverride body = body();
        System.out.println(body.singleMethod());
        System.out.println(body.defaultMethod());
    }

    static InterfaceToOverride oneline(){
        return () -> "test";
    }

    static InterfaceToOverride body(){
        return () -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 10; i++){
                builder.append(i);
            }
            return builder.toString();
        };
    }
}
