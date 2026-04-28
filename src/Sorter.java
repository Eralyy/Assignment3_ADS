import java.util.Random;

public class Sorter {

    //bubble sort
    public void basicSort(int[] arr) {

        //outer loop(passes)
        for (int i = 0; i < arr.length - 1; i++) {

            //inner loop(compares)
            for (int j = 0; j < arr.length - i - 1; j++) {

                //swap
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //merge sort(divide and conquer)
    public void advancedSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    //recursive method
    private void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);

            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    //merging
    private void merge(int[] arr, int left, int middle, int right) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        //temp arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //copy data
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        //merge temp->original
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

        //remainings
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    //printing array
    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    //random array
    public int[] generateRandomArray(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        //random nums
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
}