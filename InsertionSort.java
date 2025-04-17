import java.util.*;

public class InsertionSort {
    public static <T extends Comparable<T>> void insertionSort(final T[] input, final Comparator<T> comparator) {
        int n = input.length;
        for (int i = 1; i < n; ++i) {
            T curr = input[i];
            int j = i - 1;

            while (j >= 0 &&  comparator.compare(input[j] , curr) > 0) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = curr;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for (int i = 1; i < n; ++i) {
            T curr = input.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(input.get(j), curr) > 0) {
                input.set(j + 1, input.get(j));
                j = j - 1;
            }
            input.set(j + 1, curr);
        }
    }

    public static void main(String[] args) {
        Integer[] array1 = new Integer[10000];
        Double[] array2 = new Double[10000];
        List<Integer> list1 = new ArrayList<Integer>();
        List<Double> list2 = new ArrayList<Double>();
        Random random = new Random();

        Comparator<Integer> comparator = Integer::compareTo;
        Comparator<Double> comparator2 = Double::compare;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(10000);
            array2[i] = random.nextDouble(10000);
            list1.add(random.nextInt(10000));
            list2.add(random.nextDouble(10000));
        }

        System.out.println("Unsorted Array 1: " + Arrays.toString(array1));
        insertionSort(array1, comparator);
        System.out.println("Sorted array 1: " + Arrays.toString(array1));

        System.out.println("Unsorted Array 2: " + Arrays.toString(array2));
        insertionSort(array2, comparator2);
        System.out.println("Sorted array 2: " + Arrays.toString(array2));

        System.out.println("Unsorted List 1: " + list1);
        insertionSort(list1, comparator);
        System.out.println("Sorted list: " + list1);

        System.out.println("Unsorted List 2: " + list2);
        insertionSort(list2, comparator2);
        System.out.println("Sorted list 2: " + list2);
    }
}

