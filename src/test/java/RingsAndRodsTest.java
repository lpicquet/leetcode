import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RingsAndRodsTest {

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturns(String s, Integer expected, String message){
        assertEquals(expected, new RingsAndRods().countPoints(s), message);
    }

    public static class Source implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("B0B6G0R6R0R6G9", 1, "The rod labeled 0 holds 3 rings with all colors: red, green, and blue."),
                    Arguments.of("B0R0G0R9R0B0G0", 1, "The rod labeled 0 holds 6 rings with all colors: red, green, and blue."),
                    Arguments.of("G4", 0, "Only one ring is given. Thus, no rods have all three colors.")

            );
        }
    }

}