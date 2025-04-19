import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Define test parameters
        int[] testSizes = {10, 100, 1000, 10000, 100000};
        List<SortingAlgorithm> algorithms = Arrays.asList(
                new QuickSort(),
                new BubbleSort(),
                new BucketSort(),
                new MergeSort(),
                new HeapSort(),
                new InsertionSort(),
                new SelectionSort(),
                new SuperMergeSort()

        );

        // Pre-generate test arrays for fair comparison
        Map<Integer, int[]> testArrays = new HashMap<>();
        SortingAlgorithm arrayGenerator = new QuickSort();
        for (int size : testSizes) {
            testArrays.put(size, arrayGenerator.generateRandomArray(size));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_benchmark.csv"))) {
            // Write CSV header with both time units
            writer.write("Algorithm,Array Size,Time (ms),Time (s)\n");

            // Test each algorithm
            for (SortingAlgorithm algorithm : algorithms) {
                String algorithmName = algorithm.getClass().getSimpleName();

                // Test each array size
                for (int size : testSizes) {
                    // Get a fresh copy of the test array
                    int[] inputArray = Arrays.copyOf(testArrays.get(size), size);

                    // Time measurement
                    long startTime = System.nanoTime();
                    algorithm.sort(inputArray);
                    long endTime = System.nanoTime();

                    // Calculate durations
                    long durationNs = endTime - startTime;
                    double durationMs = durationNs / 1_000_000.0;
                    double durationS = durationNs / 1_000_000_000.0;

                    // Write results to CSV with both time formats
                    writer.write(String.format("%s,%d,%.3f,%.6f\n",
                            algorithmName,
                            size,
                            durationMs,
                            durationS));
                }
            }

            System.out.println("Benchmark results saved to sorting_benchmark.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}