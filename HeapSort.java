import java.util.Arrays;

public class HeapSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        int max = Arrays.stream(input).max().getAsInt();
        int min = Arrays.stream(input).min().getAsInt();
        
        int[] sortPos = new int[max + 1];
        int[] countPos = new int[max + 1];
        int[] sortNeg = new int[Math.abs(min) + 1];
        int[] countNeg = new int[Math.abs(min) + 1];
        int zeroCount = 0;  // New counter for zeros

        for (int num : input) {
            if (num > 0) {
                sortPos[num] = num;
                countPos[num]++;
            } else if (num < 0) {
                sortNeg[Math.abs(num)] = num;
                countNeg[Math.abs(num)]++;
            } else {
                zeroCount++;  // Count zeros
            }
        }

        int[] sortedArray = new int[input.length];
        int index = 0;

        // Negative numbers (ascending order)
        for (int i = sortNeg.length - 1; i > 0; i--) {
            if (countNeg[i] > 0) {
                Arrays.fill(sortedArray, index, index + countNeg[i], sortNeg[i]);
                index += countNeg[i];
            }
        }

        // Zeros (new section)
        if (zeroCount > 0) {
            Arrays.fill(sortedArray, index, index + zeroCount, 0);
            index += zeroCount;
        }

        // Positive numbers (ascending order)
        for (int i = 0; i < sortPos.length; i++) {
            if (countPos[i] > 0) {
                Arrays.fill(sortedArray, index, index + countPos[i], sortPos[i]);
                index += countPos[i];
            }
        }

        return sortedArray;
    }
    public static void main(String[] args) {
        int[] input = new HeapSort().sampleArray();
        int[] sorted = new HeapSort().timeSort(input);
        System.out.println(Arrays.toString(sorted));  
    }

}
