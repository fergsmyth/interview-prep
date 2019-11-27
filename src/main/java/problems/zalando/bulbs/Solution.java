package problems.zalando.bulbs;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int[] bulbs = {1,5,7,8,6};
        System.out.println(singlePass(bulbs));
    }


    public static int singlePass(int[] bulbNumbers) {
        int moments = 0;
        int highest = 0;
        Map<Integer, Integer> missing = new HashMap<>();
        for(int bulb : bulbNumbers){
            if(missing.containsKey(bulb)){
                missing.remove(bulb);
            }
            if(bulb > highest){
                for(int i = bulb - 1; i > highest; i--) {
                    missing.put(i, i);
                }
                highest = bulb;
            }
            if (missing.isEmpty()){
                moments++;
            }
        }
        return moments;
    }
}
