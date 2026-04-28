public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {

        //fair start(original data)
        int[] copiedArray = arr.clone();

        long startTime = System.nanoTime();

        if (type.equals("bubble")) {
            sorter.basicSort(copiedArray);
        }

        else if (type.equals("merge")) {
            sorter.advancedSort(copiedArray);
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {

        long startTime = System.nanoTime();

        searcher.search(arr, target);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public void runAllExperiments() {

        int[] smallArray = sorter.generateRandomArray(10);
        int[] mediumArray = sorter.generateRandomArray(100);
        int[] largeArray = sorter.generateRandomArray(1000);

        //sorted arrays for binary search
        int[] sortedSmall = smallArray.clone();
        int[] sortedMedium = mediumArray.clone();
        int[] sortedLarge = largeArray.clone();

        sorter.advancedSort(sortedSmall);
        sorter.advancedSort(sortedMedium);
        sorter.advancedSort(sortedLarge);

        //organized output
        System.out.println("===== SORTING EXPERIMENTS =====");

        //bubble
        System.out.println("\nBubble Sort:");

        System.out.println("Small Array: "
                + measureSortTime(smallArray, "bubble") + " ns");

        System.out.println("Medium Array: "
                + measureSortTime(mediumArray, "bubble") + " ns");

        System.out.println("Large Array: "
                + measureSortTime(largeArray, "bubble") + " ns");

        //merge
        System.out.println("\nMerge Sort:");

        System.out.println("Small Array: "
                + measureSortTime(smallArray, "merge") + " ns");

        System.out.println("Medium Array: "
                + measureSortTime(mediumArray, "merge") + " ns");

        System.out.println("Large Array: "
                + measureSortTime(largeArray, "merge") + " ns");

        System.out.println("\n===== SEARCHING EXPERIMENTS =====");

        //searching
        int target = sortedMedium[50];

        System.out.println("Binary Search Time: "
                + measureSearchTime(sortedMedium, target) + " ns");
    }
}