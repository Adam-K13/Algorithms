public interface SortingAlgorithm {
    /**
     * Sort an array of integers
     * @param input The array to be sorted
     * @return The sorted array
     */
    int[] sort(int[] input);
    
    /**
     * Times the execution of the sorting algorithm
     * @param input The array to be sorted
     * @return The time taken to sort in seconds
     */
    default long timeSort(int[] input) {
        long startTime = System.nanoTime();
        sort(input);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000; // Convert nanoseconds to seconds
    }

    /**
     * sampleArray
     * @param input The array to be sorted
     */
    default int[] sampleArray(){
        return new int[] {4, -2, 1, 0, -3, 2, 0, -1};  
    }
}
