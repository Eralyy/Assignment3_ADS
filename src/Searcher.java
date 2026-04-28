public class Searcher {

    //binary search
    public int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;


        while (left <= right) {

            int middle = (left + right) / 2;


            if (arr[middle] == target) {
                return middle;
            }

            else if (arr[middle] < target) {
                left = middle + 1;
            }

            else {
                right = middle - 1;
            }
        }

        return -1;
    }
}