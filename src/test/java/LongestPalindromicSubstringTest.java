import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturnsTheLongestPalindrome(String input, List<String> expected, String message) {
        assertThat(longestPalindromicSubstring.longestPalindrome(input)).isIn(expected).describedAs(message);
    }

    public static class Source implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("a", List.of("a"), ""),
                    Arguments.of("aa", List.of("aa"), ""),
                    Arguments.of("ab", List.of("a", "b"), ""),
                    Arguments.of("aaa", List.of("aaa"), ""),
                    Arguments.of("abc", List.of("a", "b", "c"), ""),
                    Arguments.of("aba", List.of("aba"), ""),
                    Arguments.of("abb", List.of("bb"), ""),
                    Arguments.of("abba", List.of("abba"), ""),
                    Arguments.of("aaca", List.of("aca"), ""),
                    Arguments.of("aaca", List.of("aca"), ""),
                    Arguments.of("abbc", List.of("bb"), ""),
                    Arguments.of("acda", List.of("a", "c", "d"), ""),
                    Arguments.of("babad", List.of("bab", "aba"), ""),
                    Arguments.of("ac", List.of("a", "c"), ""),
                    Arguments.of("ccc", List.of("ccc"), ""),
                    Arguments.of("baaaa", List.of("aaaa"), ""),
                    Arguments.of("bab", List.of("bab"), ""),
                    Arguments.of("baab", List.of("baab"), ""),
                    Arguments.of("abaab", List.of("baab"), ""),
                    Arguments.of("abadab", List.of("badab"), ""),
                    Arguments.of("cbbd", List.of("bb"), ""),
                    Arguments.of("aacabdkacaa", List.of("aca"), "")

            )
//                    .filter( arguments -> arguments.get()[0].equals("a"))
                    ;
        }
    }
}