import java.util.*;

public class SuperMergeSort {

    public static void sort(int[] input) {
        int n = input.length;

        // Step 1: Find max and min
        int max = input[0], min = input[0];
        for (int value : input) {
            if (value > max) max = value;
            if (value < min) min = value;
        }

        int offset = -min; // To shift negatives into positive indices

        // Step 2: Declare arrays
        int t = 0;                      // For zero count
        int[] countp = new int[max + 1];           // For positive values
        int[] countn = new int[offset + 1];        // For negative values

        // Step 3: Process input values
        for (int x = 0; x < n; x++) {
            int val = input[x];

            if (val == 0) {
                t++;
            } else if (val > 0) {
                countp[val]++;
            } else { // val < 0
                int negIndex = val + offset;
                countn[negIndex]++;
            }
        }

        // Step 4: Output sorted array

        // Print sorted negative values from smallest to largest
        for (int i = 0; i <= offset; i++) {
            int value = -offset + i;  // Convert index back to original negative value
            for (int j = 0; j < countn[i]; j++) {
                System.out.print(value + " ");
            }
        }

        // Print zeros
        for (int i = 0; i < t; i++) {
            System.out.print("0 ");
        }

        // Print sorted positive values
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < countp[i]; j++) {
                System.out.print(i + " ");
            }
        }

        System.out.println(); // newline
    }


    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(17) - 8;  // Generates value from -8 to 8
        }

        return array;
    }

    public static void main(String[] args) {
        int[] input = generateRandomArray(1000000);  // example input
        sort(input);  // Expected: -3 -3 -1 0 0 2 2 4
    }
}

