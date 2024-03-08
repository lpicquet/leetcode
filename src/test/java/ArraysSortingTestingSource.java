import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.*;
import java.util.stream.Stream;

public class ArraysSortingTestingSource implements ArgumentsProvider {
    // a bit of properties testing

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {

        int examplesCount = 100;
        int maxLength = 10;
        Random random = new Random();
        List<Arguments> arguments = new ArrayList<>(examplesCount);
        for (int i = 0; i < examplesCount; i++) {
            List<Integer> numbers = new ArrayList<>(maxLength);
            int length = random.nextInt(maxLength);
            for (int j = 0; j < length; j++) {
                numbers.add(random.nextInt(10)); // get a new digit
            }
            arguments.add(Arguments.of(shuffle(numbers), "The list should be sorted"));
        }

        return arguments.stream();
    }

    private static int[] shuffle(Collection<Integer> numbers) {
        List<Integer> shufflednumbers = new ArrayList<>(numbers);
        Collections.shuffle(shufflednumbers);
        int[] ints = new int[shufflednumbers.size()];
        for (int i = 0; i < shufflednumbers.size(); i++) {
            ints[i] = shufflednumbers.get(i);
        }
        return ints;
    }
}

