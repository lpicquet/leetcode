import java.util.Arrays;

public class SelectionSort implements ArraySort {
    public int[] sort(int[] toSort) {
        int[] sortedCopy = Arrays.copyOf(toSort, toSort.length);
        for (int i = 0; i < sortedCopy.length - 1; i++) {
            int min = sortedCopy[i];
            int min_index = i;
            for (int j = i+1; j < sortedCopy.length; j++) {
                if (sortedCopy[j] < min) {
                    min = sortedCopy[j];
                    min_index = j;
                }
            }
            // we have done the whole row, we know which one is the minimum value to place at index i
            ArraysUtil.swap(sortedCopy, i, min_index);
        }
        return sortedCopy;
    }
}
