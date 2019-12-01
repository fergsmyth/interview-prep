package javaknowledge.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectionTest {
    /**
     * Taken from https://winterbe.com/posts/2018/09/24/java-11-tutorial/
     * */
    public static void main(String[] args) {

        var immutableList = List.of("a", "b", "c");
        // list.add("no allowed");
        var immutableCopy = List.copyOf(immutableList);
        // copy.add("no allowed");
        // Same as list is immutable
        System.out.println(immutableList == immutableCopy);

        // Copy is a new list to avoid side effects on old list.
        var mutableList = new ArrayList<String>();
        var mutableListCopy = List.copyOf(mutableList);
        System.out.println(mutableList == mutableListCopy);

        // Copies are immutable.
        // mutableListCopy.add("not allowed");

        var map = Map.of("A", 1, "B", 2);
        System.out.println(map);


    }


}
