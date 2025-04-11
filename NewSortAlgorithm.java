public class NewSortAlgorithm {

    /**
     * Implements the new sorting algorithm.
     * It first scans for min/max values and then counts frequencies.
     * Finally, it reconstructs the sorted array by processing negatives,
     * zeros, and positives separately.
     */
    public static int[] newSort(int[] input) {
        // ***** ALGORITHM 1: First part - Scan and count *****
        // 1. Find maximum and minimum values in the input.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : input) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 2. Prepare frequency arrays:
        //    - Count for zeros (t in pseudo-code)
        //    - Array for positive numbers: posCount (b, countp in pseudo-code)
        //    - Array for negatives: negCount (k, countn in pseudo-code)
        int zeroCount = 0;
        int[] posCount = new int[max + 1];       // indices 0..max (we use index directly as value)
        int[] negCount = null;
        if (min < 0) {
            // For negatives, we map value -X to index X.
            negCount = new int[-min + 1];         // indices 0..(-min)
        }

        // 3. Traverse the input and count occurrences.
        // This loop corresponds to the "for x in input[n]" block in the pseudo-code.
        for (int num : input) {
            if (num == 0) {
                // If the element is zero.
                zeroCount++;
            } else if (num > 0) {
                // Positive number:
                posCount[num]++; // sortp is set implicitly since the value is the index.
            } else {
                // Negative number: shift the index by taking its absolute value.
                // Pseudo-code uses: sortn{input[x] + max} = input[x];
                negCount[-num]++; // here, index "-num" corresponds to value.
            }
        }

        // ***** ALGORITHM 2: Second part - Reconstruct and output the sorted array *****
        // Create the resulting sorted array.
        int[] sorted = new int[input.length];
        int index = 0;

        // 1. Process negative numbers.
        //    We want the most negative values first. Since we stored negatives by absolute value,
        //    iterate from highest index (largest absolute value) to lowest.
        if (negCount != null) {
            for (int i = negCount.length - 1; i >= 1; i--) {
                for (int j = 0; j < negCount[i]; j++) {
                    // Print negative as "-i". (In pseudo-code: print ("-" + (i+1) + " "))
                    sorted[index++] = -i;
                }
            }
        }

        // 2. Process zeroes.
        // In the pseudo-code, t[0] is used to count zeros.
        for (int i = 0; i < zeroCount; i++) {
            sorted[index++] = 0;
        }

        // 3. Process positive numbers.
        // Iterate through the positive frequency array (corresponding to sortp and countp in pseudo-code).
        for (int i = 1; i < posCount.length; i++) {
            for (int j = 0; j < posCount[i]; j++) {
                sorted[index++] = i;
            }
        }

        // Return the sorted array.
        return sorted;
    }

    public static void main(String[] args) {
        // Example input (feel free to modify)
        int[] input = {4, -2, 1, 0, -3, 2, 3, -1};

        // Call the sorting algorithm.
        int[] sorted = newSort(input);

        // Print the sorted array.
        System.out.println("Sorted Array:");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
