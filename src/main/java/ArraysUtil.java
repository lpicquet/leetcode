public class ArraysUtil {
    /**
     * swaps the values at the 2 positions in an array
     *
     * @param anArray     the array containing the values to swap
     * @param firstIndex  the 0 based index position ofg the first value to swap
     * @param secondIndex the 0 based index position of the second value to swap
     */
    public static void swap(int[] anArray, int firstIndex, int secondIndex) {
        int temp = anArray[secondIndex];
        anArray[secondIndex] = anArray[firstIndex];
        anArray[firstIndex] = temp;
    }
}