public class Searcher {

    // Binary Search method
    public int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        // Continue searching while left index is smaller or equal to right
        while (left <= right) {

            // Find middle index
            int middle = (left + right) / 2;

            // If target found
            if (arr[middle] == target) {
                return middle;
            }

            // If target is bigger, search right half
            else if (arr[middle] < target) {
                left = middle + 1;
            }

            // If target is smaller, search left half
            else {
                right = middle - 1;
            }
        }

        // Return -1 if target not found
        return -1;
    }
}