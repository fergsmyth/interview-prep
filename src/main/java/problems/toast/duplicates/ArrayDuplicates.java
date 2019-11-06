package problems.toast.duplicates;

import java.util.HashSet;

public class ArrayDuplicates {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,5,6,7,8};
        int duplicate = new ArrayDuplicates().findFirstDuplicateIndex(array);
        if(duplicate != -1){
            System.out.println(String.format("Found duplicate value of %d at index %d", array[duplicate], duplicate));
        }
    }

    public int findFirstDuplicateIndex(int[] array){
        int duplicateIndex = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            int value = array[i];
            if(set.contains(value)){
                duplicateIndex = i;
                break;
            } else {
                set.add(value);
            }
        }
        return duplicateIndex;
    }
}
