import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionSortTest extends ArraysSortingTest<SelectionSort> {

    @Override
    SelectionSort getInstanceUnderTest() {
        return new SelectionSort();
    }

}
