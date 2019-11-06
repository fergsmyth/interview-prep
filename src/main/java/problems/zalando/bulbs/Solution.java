package problems.zalando.bulbs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int[] bulbs = {1,5,7,8,6};
        System.out.println(singlePass(bulbs));
        //        System.out.println(reverseListCheck(bulbs));
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
//    public static int reverseListCheck(int[] bulbNumbers) {
//        int moments = 0;
//        LinkedList<Boolean> bulbs = new LinkedList<>();
//        int latestBulbOn = 0;
//        for(int bulbNumber : bulbNumbers){
//            if(bulbNumber > bulbNumbers.length) {
//                return moments;
//            }
//            bulbs.add(false);
//        }
//
//        for(int i = 0; i < bulbNumbers.length; i++){
//            int bulbNumber = bulbNumbers[i];
//            if(bulbNumber > latestBulbOn){
//                latestBulbOn = bulbNumber;
//            }
//            bulbs.set(bulbNumber - 1, true);
//            ListIterator<Boolean> iterator = bulbs.listIterator(latestBulbOn);
//            while(iterator.hasPrevious()){
//                Boolean state = iterator.previous();
//                if(state == false){
//                    break;
//                } else if(!iterator.hasPrevious()){
//                    moments++;
//                }
//            }
//        }
//        return moments;
//    }
}
