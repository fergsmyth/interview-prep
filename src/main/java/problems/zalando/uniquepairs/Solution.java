package problems.zalando.uniquepairs;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] pairs = {
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                2,2,2,2,2,2,2,2,2,2,2,2,2,2,2
        };
        System.out.println(countPairs(pairs));
    }

    public static int countPairs(int[] indicies){
        Map<Integer, HashSet<Integer>> mappings = new HashMap<>();
        for(int i = 0; i < indicies.length; i++){
            int key = indicies[i];
            if(mappings.containsKey(key)){
                HashSet<Integer> integers = mappings.get(key);
                integers.add(i);
            } else {
                HashSet<Integer> integers = new HashSet<>();
                integers.add(i);
                mappings.put(key, integers);
            }
        }

        BigInteger totalPairs = BigInteger.ZERO;
        for(Set<Integer> integers : mappings.values()){
            int numberOfChoices = 2;
            int size = integers.size();
            BigInteger factorialChoice = factorial(numberOfChoices);
            BigInteger factorialSizeMinusChoice = factorial(size - numberOfChoices);
            BigInteger factorialSize = factorial(size);
            totalPairs = totalPairs.add(factorialSize.divide(factorialChoice.multiply(factorialSizeMinusChoice)));
        }

        return totalPairs.intValue();
    }

    public static BigInteger factorial(int n){
        BigInteger combos = BigInteger.ONE;
        for (int i = 2;  i <= n; i++){
            combos = combos.multiply(BigInteger.valueOf(i));
        }
        return combos;
    }
}
