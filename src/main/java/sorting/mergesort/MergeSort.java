package sorting.mergesort;

public class MergeSort {

    public static void main(String args[]) {
        System.out.println("Testing compiler etc");
    }

    private void mergeSort(int[] arrayToSort, int leftIndex, int rightIndex){
        if(rightIndex <= leftIndex) return;
        int midIndex = (leftIndex + rightIndex) / 2;
        mergeSort(arrayToSort, leftIndex, midIndex);
        mergeSort(arrayToSort, rightIndex, midIndex + 1);
        merge(arrayToSort, leftIndex, rightIndex, midIndex);
    }
}