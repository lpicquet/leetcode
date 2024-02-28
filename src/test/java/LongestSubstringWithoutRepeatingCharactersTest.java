import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @ArgumentsSource(LongestSubstringWithoutRepeatingCharactersTest.Source.class)
    public void itReturns(String s, Integer expected, String message){
        assertEquals(expected, new LongestSubstringWithoutRepeatingCharacters().apply(s), message);
    }

    public static class Source implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("a", 1, "It's only one letter"),
                    Arguments.of("aa", 1, "It's only one letter, repeated"),
                    Arguments.of("ab", 2, "It's 2 letters"),
                    Arguments.of("aba", 2, "It's 2 letters, plus 1 repeat for a"),
                    Arguments.of("ababc", 3, "It's 3 letters (abc), plus 1 repeat for a"),
                    Arguments.of("abcabcbb", 3, "\"abc\", with the length of 3"),
                    Arguments.of("bbbbb", 1, "\"b\", with the length of 1"),
                    Arguments.of("pwwkew", 3, "\"wke\", with the length of 3"),
                    Arguments.of("abacd", 4, "\"bacd\", with the length of 4"),
                    Arguments.of("dvdf", 3, "\"vdf\", with the length of 3")

            );
        }
    }
}
