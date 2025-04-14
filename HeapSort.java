import java.util.Arrays;

public class HeapSort {

    public static void modifiedSort(int[] input) {
        // Find the maximum and minimum values in the array
        int max = Arrays.stream(input).max().getAsInt();
        int min = Arrays.stream(input).min().getAsInt();

        // Create arrays for positive and negative numbers
        int[] sortPos = new int[max + 1];
        int[] countPos = new int[max + 1];
        int[] sortNeg = new int[Math.abs(min) + 1];
        int[] countNeg = new int[Math.abs(min) + 1];

        // First part: Sorting and counting
        for (int num : input) {
            if (num > 0) {
                sortPos[num] = num;
                countPos[num]++;
            } else if (num < 0) {
                sortNeg[Math.abs(num)] = num;
                countNeg[Math.abs(num)]++;
            }
        }

        // Second part: Printing sorted values
        System.out.println("Sorted Array:");

        // Print negative numbers in ascending order
        for (int i = sortNeg.length - 1; i > 0; i--) {
            if (countNeg[i] > 0) {
                for (int j = 0; j < countNeg[i]; j++) {
                    System.out.print(sortNeg[i] + " ");
                }
            }
        }

        // Print positive numbers in ascending order
        for (int i = 0; i < sortPos.length; i++) {
            if (countPos[i] > 0) {
                for (int j = 0; j < countPos[i]; j++) {
                    System.out.print(sortPos[i] + " ");
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Example input array
        int[] inputArray = {3, -2, -2, 5, -7, 3, -7, 5, 2};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(inputArray));

        // Call the modified sorting algorithm
        modifiedSort(inputArray);
    }
}

