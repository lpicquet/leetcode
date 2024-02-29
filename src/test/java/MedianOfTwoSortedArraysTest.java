import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTest {

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturns(int[] nums1, int[] nums2, Integer expected, String message){
        assertEquals(expected, new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2), message);
    }

    public static class Source implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,3}, new int[]{2}, 2, "merged array = [1,2,3] and median is 2.")
            );
        }
    }

}
