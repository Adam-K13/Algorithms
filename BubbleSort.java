import java.util.*;

public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for(int i =0; i < n-1; i++) {

            for(int j =0; j < n-i-1; j++) {
                if(comparator.compare(input.get(j + 1), input.get(j)) < 0) {
                    T temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] input, final Comparator<T> comparator) {
        int n = input.length;
        for (int i=0;i<n-1;++i){

            for(int j=0;j< n - i-1; ++j){

                if(comparator.compare(input[j+1], input[j]) < 0 ){
                    T temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
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
        bubbleSort(array1, comparator);
        System.out.println("Sorted array 1: " + Arrays.toString(array1));

        System.out.println("Unsorted Array 2: " + Arrays.toString(array2));
        bubbleSort(array2, comparator2);
        System.out.println("Sorted array 2: " + Arrays.toString(array2));

        System.out.println("Unsorted List 1: " + list1);
        bubbleSort(list1, comparator);
        System.out.println("Sorted list: " + list1);

        System.out.println("Unsorted List 2: " + list2);
        bubbleSort(list2, comparator2);
        System.out.println("Sorted list 2: " + list2);
    }
}

