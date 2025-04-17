import java.util.*;

public class SelectionSort {
    public static <T extends Comparable<T>> void selectionSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for (int i = 0; i < input.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = input.get(i);
                input.set(i, input.get(minIndex));
                input.set(minIndex, temp);
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] input, final Comparator<T> comparator) {
        T temp;
        int n = input.length;
        int min;

        for (int i = 0; i < n - 1; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(input[min], input[j]) > 0) {
                    min = j;
                }
            }

            temp = input[i];
            input[i] = input[min];
            input[min] = temp;
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
        selectionSort(array1, comparator);
        System.out.println("Sorted array 1: " + Arrays.toString(array1));

        System.out.println("Unsorted Array 2: " + Arrays.toString(array2));
        selectionSort(array2, comparator2);
        System.out.println("Sorted array 2: " + Arrays.toString(array2));

        System.out.println("Unsorted List 1: " + list1);
        selectionSort(list1, comparator);
        System.out.println("Sorted list: " + list1);

        System.out.println("Unsorted List 2: " + list2);
        selectionSort(list2, comparator2);
        System.out.println("Sorted list 2: " + list2);
    }
}
