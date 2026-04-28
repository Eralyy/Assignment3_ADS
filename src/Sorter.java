import java.util.Random;

public class Sorter {

    // Bubble Sort (Basic Sorting Algorithm)
    public void basicSort(int[] arr) {

        // Outer loop controls number of passes
        for (int i = 0; i < arr.length - 1; i++) {

            // Inner loop compares adjacent elements
            for (int j = 0; j < arr.length - i - 1; j++) {

                // Swap if left element is bigger than right element
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (Advanced Sorting Algorithm)
    public void advancedSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Recursive method for Merge Sort
    private void mergeSort(int[] arr, int left, int right) {

        // Continue dividing while left index is smaller than right
        if (left < right) {

            // Find middle index
            int middle = (left + right) / 2;

            // Sort left half
            mergeSort(arr, left, middle);

            // Sort right half
            mergeSort(arr, middle + 1, right);

            // Merge sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Method for merging two sorted parts
    private void merge(int[] arr, int left, int middle, int right) {

        // Sizes of temporary arrays
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        // Temporary arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data into left temporary array
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }

        // Copy data into right temporary array
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Merge temporary arrays back into original array
        while (i < leftSize && j < rightSize) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left array
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Method for printing array
    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Method for generating random array
    public int[] generateRandomArray(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        // Fill array with random numbers
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
}