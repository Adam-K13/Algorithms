
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    public static <T extends Comparable<? super T>> void mergeSort(final T[] data, final Comparator<T> comparator) {
        int length = data.length;

        if(length < 2) {
            return;
        }

        int middle = length / 2;

        T[] leftHalf = Arrays.copyOfRange(data, 0,middle);
        T[] rightHalf = Arrays.copyOfRange(data, middle ,length);

        mergeSort(leftHalf, comparator);
        mergeSort(rightHalf, comparator);

        merge(data, leftHalf, rightHalf);

    }

    public static <T extends Comparable<? super T>> void merge(T[] data, T[] leftHalf, T[] rightHalf) {
        int lSize = leftHalf.length ;
        int rSize = rightHalf.length ;

        int lIndex = 0, rIndex = 0, dIndex = 0;

        while( (lIndex < lSize) && (rIndex < rSize )) {
            if(leftHalf[lIndex].compareTo(rightHalf[rIndex]) < 0) {
                data[dIndex] = leftHalf[lIndex];
                lIndex++;
            } else {
                data[dIndex] = rightHalf[rIndex];
                rIndex++;
            }
            dIndex++;
        }

        while(lIndex < lSize) {
            data[dIndex] = leftHalf[lIndex];
            lIndex++;
            dIndex++;
        }

        while(rIndex < rSize) {
            data[dIndex] = rightHalf[rIndex];
            rIndex++;
            dIndex++;
        }

    }

    public static <T extends Comparable<? super T>> void mergeSort(final List<T> data, final Comparator<T> comparator) {
        int length = data.size();

        if(length < 2) {
            return;
        }

        int middle = length / 2;

        List<T> leftHalf = new ArrayList<>();
        List<T> rightHalf = new ArrayList<>();

        for(int i = 0; i < middle; i++) {
            leftHalf.add(data.get(i));
        }

        for(int i = middle; i < length; i++) {
            rightHalf.add(data.get(i));
        }

        mergeSort(leftHalf, comparator);
        mergeSort(rightHalf, comparator);

        mergeList(data, leftHalf, rightHalf);

    }

    public static <T extends Comparable<? super T>> void mergeList(List<T> data, List<T> leftHalf, List<T> rightHalf) {
        int lSize = leftHalf.size();
        int rSize = rightHalf.size();

        int lIndex = 0, rIndex = 0, dIndex = 0;

        while( (lIndex < lSize) && (rIndex < rSize )) {
            if(leftHalf.get(lIndex).compareTo(rightHalf.get(rIndex)) < 0) {
                data.set(dIndex, leftHalf.get(lIndex));
                lIndex++;
            } else {
                data.set(dIndex, rightHalf.get(rIndex));
                rIndex++;
            }
            dIndex++;
        }

        while(lIndex < lSize) {
            data.set(dIndex, leftHalf.get(lIndex));
            lIndex++;
            dIndex++;
        }

        while(rIndex < rSize) {
            data.set(dIndex, rightHalf.get(rIndex));
            rIndex++;
            dIndex++;
        }

    }



    public static void main(String[] args) {
        Integer[] numbers = {6,4,8,3,5,9,5,3,6,8,66,4,8,323,7,4,8867,1246,8,544,8,4,8,2,1,5,9,5};

        System.out.println("Before sorting Array: " + Arrays.toString(numbers));

        mergeSort(numbers, Comparator.naturalOrder());

        System.out.println("After sorting Array: " + Arrays.toString(numbers));

        List<Integer> list = Arrays.asList(5,2,8,5,0,1,34,28,9,1,32,9,12,7,7,54,32,3,7,6,33,6,57,4);

        System.out.println("\nBefore sorting list: " + list);
        mergeSort(list, Comparator.naturalOrder());
        System.out.println("After sorting list: " + list);
    }
}




