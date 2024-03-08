import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortTest extends ArraysSortingTest<BubbleSort>{

    @Override
    BubbleSort getInstanceUnderTest() {
        return new BubbleSort();
    }
}
