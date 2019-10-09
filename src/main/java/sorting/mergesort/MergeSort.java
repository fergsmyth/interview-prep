package sorting.mergesort;

public class MergeSort {

    public static void main(String args[]) {
        int[] arrayToSort = {12, 14, 16, 1, 3, 4, 17, 20};
        new MergeSort().mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        for (int value : arrayToSort){
            System.out.print(value + " ");
        }
    }

    public void mergeSort(int[] arrayToSort, int leftIndex, int rightIndex){
        if(rightIndex <= leftIndex) return;
        int midIndex = (leftIndex + rightIndex) / 2;
        System.out.println(midIndex);
        mergeSort(arrayToSort, leftIndex, midIndex);
        mergeSort(arrayToSort, midIndex + 1, rightIndex);
        merge(arrayToSort, leftIndex, midIndex, rightIndex);
    }

    private void merge(int[] arrayToSort, int leftIndex, int midIndex, int rightIndex) {
        System.out.println(String.format("Left %d, mid %d, right %d", leftIndex, midIndex, rightIndex));
        int leftLength = midIndex - leftIndex + 1;
        System.out.println("Left length " + leftLength);
        int rightLength = rightIndex - midIndex;
        System.out.println("Right length " + rightLength);
        // rightLength : 8 - 4 = 4

        // 0 - 3
        int[] leftArray = new int[leftLength];
        // 4 - 7
        int[] rightArray = new int[rightLength];

        // 0 -> 3
        for(int i = 0; i < leftLength; i++) {
            leftArray[i] = arrayToSort[leftIndex + i];
        }
        System.out.println("");
        // 4 --> 7
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = arrayToSort[midIndex + i];
        }

        int leftInsertIndex = 0;
        int rightInsertIndex = 0;
        for(int i = leftIndex; i < rightIndex; i++){
            if(leftInsertIndex < leftLength && rightInsertIndex < rightLength) {
                if (leftArray[leftInsertIndex] < rightArray[rightInsertIndex]) {
                    arrayToSort[i] = leftArray[leftInsertIndex];
                    leftInsertIndex++;
                } else {
                    arrayToSort[i] = rightArray[rightInsertIndex];
                    rightInsertIndex++;
                }
            } else if(leftInsertIndex < leftLength) {
                arrayToSort[i] = leftArray[leftInsertIndex];
                leftInsertIndex++;
            } else if(rightInsertIndex < rightLength){
                arrayToSort[i] = rightArray[rightInsertIndex];
                rightInsertIndex++;
            }
        }
    }
}