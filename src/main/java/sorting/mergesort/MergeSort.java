package sorting.mergesort;

public class MergeSort {

    public static void main(String args[]) {
        int[] arrayToSort = {12, 14, 16, 1, 1, 3, 14, 20, 1, 3, 4, 17, 20};
        new MergeSort().mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        for (int value : arrayToSort)
            System.out.print(value + " ");
    }

    public void mergeSort(int[] arrayToSort, int leftIndex, int rightIndex){
        // Return if the array can no longer be divided (single element)
        if(rightIndex <= leftIndex) return;
        // Find middle position between current left and right positions
        int midIndex = (leftIndex + rightIndex) / 2;
        // Perform recursive call to divide array.
        mergeSort(arrayToSort, leftIndex, midIndex);
        mergeSort(arrayToSort, midIndex + 1, rightIndex);
        merge(arrayToSort, leftIndex, midIndex, rightIndex);
    }

    private void merge(int[] arrayToSort, int leftIndex, int midIndex, int rightIndex) {
        // Establish the number of elements for the left and right sides.
        int leftLength = midIndex - leftIndex + 1;
        int rightLength = rightIndex - midIndex;

        // Create two temporary arrays for the left and right
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        // Fill the left array with values from the original array starting at the left index parameter.
        for(int i = 0; i < leftLength; i++)
            leftArray[i] = arrayToSort[leftIndex + i];
        // Fill the right array with values from the original array starting at the right index parameter.
        for (int i = 0; i < rightLength; i++)
            rightArray[i] = arrayToSort[midIndex + i + 1];

        // Initialize indices for both temp arrays.
        int leftTempIndex = 0;
        int rightTempIndex = 0;
        // Loop from original arrays leftIndex to the rightIndex.
        for(int i = leftIndex; i < rightIndex + 1; i++){
            // Where both temporary arrays still have values to sort.
            if(leftTempIndex < leftLength && rightTempIndex < rightLength) {
                // If the left is smaller than right, insert in position, otherwise insert right. Increment corresponding temp array index.
                if (leftArray[leftTempIndex] < rightArray[rightTempIndex]) {
                    arrayToSort[i] = leftArray[leftTempIndex];
                    leftTempIndex++;
                } else {
                    arrayToSort[i] = rightArray[rightTempIndex];
                    rightTempIndex++;
                }
            }
            // If elements still in left array, insert in position and increment temp array index
            else if(leftTempIndex < leftLength) {
                arrayToSort[i] = leftArray[leftTempIndex];
                leftTempIndex++;
            }
            // If elements still in right array, insert in position and increment temp array index
            else if(rightTempIndex < rightLength){
                arrayToSort[i] = rightArray[rightTempIndex];
                rightTempIndex++;
            }
        }
    }
}