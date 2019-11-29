package javaknowledge.lvt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LocalVariableTypes {

    public static void main(String[] args) {

    }
    /**
     * Taken from https://winterbe.com/posts/2018/09/24/java-11-tutorial/
     * */
    public void localVariableTypes(){
        String hello = "Hello Java 9";
        var text = "Hello Java 9 variables";
        // text = 1; incompatible type
        final var cannotChange = "Constant";
        // cannotChange = "not constant"; Cannot reassign

        // Cannot infer type from the following
        // var infer;
        // var nullVar = null;
        // var lambda = () -> System.out.println("Cannot infer lambda");
        // var method = this::localVariableTypes;

        var myList = new ArrayList<Map<String, List<Integer>>>();

        for (var item : myList){
            System.out.println(item);
        }

        Predicate<String> predicate = (var a) -> true;

    }
}
