package problems.migratorybirds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        // Weird protection against OoBEx
        int[] counts = new int[6];

        for(int type : arr){
            counts[type]++;
            // Small efficiency gain if we keep track of the max value encountered?
        }

        int firstMaxPos = 0, firstMaxVal = 0;
        for(int i = 0; i < 6; i++){
            if(counts[i] > firstMaxVal){
                firstMaxPos = i;
                firstMaxVal = counts[i];
            }
        }

        System.out.println(firstMaxPos);
        System.out.println(firstMaxVal);
        return firstMaxPos;
    }

    // Complete the migratoryBirds function below.
    static int migratoryBirds2(List<Integer> arr) {
        Map<Integer, Integer> typeCountMap = new HashMap<>();
        for(int type : arr){
            System.out.println(type);
            if(typeCountMap.get(type) == null){
                System.out.println("No entry found");
                typeCountMap.put(type, new Integer(1));
            } else {
                Integer typeCount = typeCountMap.get(type) + 1;
                typeCountMap.put(type, typeCount);
                System.out.println(typeCount);
            }
        }

        Map.Entry<Integer, Integer> firstMaxEntry = null;
        for(Map.Entry<Integer, Integer> entry : typeCountMap.entrySet()){
            if(firstMaxEntry == null || entry.getValue() > firstMaxEntry.getValue()){
                firstMaxEntry = entry;
            }
        }

        if(firstMaxEntry == null){
            return -1;
        } else {
            return firstMaxEntry.getKey();
        }
    }

}
