import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input.length == 0) {
            return input.clone();
        }

        // Create a copy of the input array to preserve the original
        int[] result = input.clone();
        
        // Find minimum and maximum values
        int minValue = result[0];
        int maxValue = result[0];
        for (int i = 1; i < result.length; i++) {
            if (result[i] < minValue) {
                minValue = result[i];
            } else if (result[i] > maxValue) {
                maxValue = result[i];
            }
        }

        // Create buckets (handle negative numbers by shifting)
        int offset = (minValue < 0) ? -minValue : 0;
        int range = maxValue - minValue + 1;
        int bucketCount = Math.max(1, Math.min(range, result.length));
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        for (int value : result) {
            int shiftedValue = value + offset;
            int bucketIndex = (int) ((bucketCount * shiftedValue) / (range));
            buckets.get(bucketIndex).add(value);
        }

        // Sort each bucket and put back into result array
        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int value : bucket) {
                result[currentIndex++] = value;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] input = new BucketSort().sampleArray();
        int[] sorted = new BucketSort().timeSort(input);
        System.out.println(Arrays.toString(sorted));  
    }
}
