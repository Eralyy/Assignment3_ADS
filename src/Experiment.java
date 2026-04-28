public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    // Method for measuring sorting time
    public long measureSortTime(int[] arr, String type) {

        // Copy array so original data is not changed
        int[] copiedArray = arr.clone();

        long startTime = System.nanoTime();

        // Run selected sorting algorithm
        if (type.equals("bubble")) {
            sorter.basicSort(copiedArray);
        }

        else if (type.equals("merge")) {
            sorter.advancedSort(copiedArray);
        }

        long endTime = System.nanoTime();

        // Return execution time
        return endTime - startTime;
    }

    // Method for measuring searching time
    public long measureSearchTime(int[] arr, int target) {

        long startTime = System.nanoTime();

        searcher.search(arr, target);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    // Method for running all experiments
    public void runAllExperiments() {

        // Generate arrays of different sizes
        int[] smallArray = sorter.generateRandomArray(10);
        int[] mediumArray = sorter.generateRandomArray(100);
        int[] largeArray = sorter.generateRandomArray(1000);

        // Create sorted arrays for Binary Search
        int[] sortedSmall = smallArray.clone();
        int[] sortedMedium = mediumArray.clone();
        int[] sortedLarge = largeArray.clone();

        sorter.advancedSort(sortedSmall);
        sorter.advancedSort(sortedMedium);
        sorter.advancedSort(sortedLarge);

        // Print title
        System.out.println("===== SORTING EXPERIMENTS =====");

        // Bubble Sort
        System.out.println("\nBubble Sort:");

        System.out.println("Small Array: "
                + measureSortTime(smallArray, "bubble") + " ns");

        System.out.println("Medium Array: "
                + measureSortTime(mediumArray, "bubble") + " ns");

        System.out.println("Large Array: "
                + measureSortTime(largeArray, "bubble") + " ns");

        // Merge Sort
        System.out.println("\nMerge Sort:");

        System.out.println("Small Array: "
                + measureSortTime(smallArray, "merge") + " ns");

        System.out.println("Medium Array: "
                + measureSortTime(mediumArray, "merge") + " ns");

        System.out.println("Large Array: "
                + measureSortTime(largeArray, "merge") + " ns");

        // Searching experiments
        System.out.println("\n===== SEARCHING EXPERIMENTS =====");

        int target = sortedMedium[50];

        System.out.println("Binary Search Time: "
                + measureSearchTime(sortedMedium, target) + " ns");
    }
}