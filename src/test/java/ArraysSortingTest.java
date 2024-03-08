import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ArraysSortingTest<E extends ArraySort> {

    @ParameterizedTest
    @ArgumentsSource(ArraysSortingTestingSource.class)
    public void itMaintainsTheSize(int[] toSort, String message) {
        int[] sorted = getInstanceUnderTest().sort(toSort);
        assertThat(sorted).hasSameSizeAs(toSort);
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSortingTestingSource.class)
    public void elementsAreInIncreasingOrder(int[] toSort, String message) {
        int[] sorted = getInstanceUnderTest().sort(toSort);
        assertThat(sorted).hasSameSizeAs(toSort);
        for (int i=0; i<sorted.length -1; i++){
            assertThat(sorted[i]).isLessThanOrEqualTo(sorted[i+1]).describedAs(" elements of {} are not in increasing order", sorted);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ArraysSortingTestingSource.class)
    public void itSortsTheSameElements(int[] toSort, String message) {
        int[] sorted = getInstanceUnderTest().sort(toSort);
        HashSet<Integer> sortedSet = new HashSet<>(Arrays.stream(sorted).boxed().toList());
        HashSet<Integer> unsortedSet = new HashSet<>(Arrays.stream(toSort).boxed().toList());
        assertThat(sortedSet).containsExactlyInAnyOrderElementsOf(unsortedSet);
    }


    @ParameterizedTest
    @ArgumentsSource(ArraysSortingTestingSource.class)
    public void itShouldNotModifyTheOriginalArray(int[] toSort, String message) {
        int[] sorted = getInstanceUnderTest().sort(toSort);
        assertThat(sorted).isNotSameAs(toSort);
    }

    abstract E getInstanceUnderTest();


}
