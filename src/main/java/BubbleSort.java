import java.util.Arrays;


public class BubbleSort implements ArraySort {

    /**
     * returns a sorted copy of the array
     * @param toSort the array to sort. This array is not modified.
     * @return a sorted copy of the array
     */
    public int[] sort(int[] toSort) {
        int[] sortedCopy = Arrays.copyOf(toSort, toSort.length);
        for (int i=0; i< sortedCopy.length -1; i++){
            for (int j=i+1; j<sortedCopy.length; j++){
                if (sortedCopy[i] > sortedCopy[j]){
                    ArraysUtil.swap(sortedCopy, i, j);
                }
            }
        }

        return sortedCopy;
    }

}
