import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
class LongestValidParenthesesTest {

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturns(String s, Integer expected, String message){
        assertEquals(expected, new LongestValidParentheses().longestValidParenthesesFromYoutube(s), message);
    }

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturnsOther(String s, Integer expected, String message){
        assertEquals(expected, new LongestValidParentheses().longestValidParentheses(s), message);
    }


    public static class Source implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("", 0, "There are no parenthesis."),
                    Arguments.of(")", 0, "The parenthesis is invalid."),
                    Arguments.of("(", 0, "The parenthesis is invalid, as it is not closed."),
                    Arguments.of("((", 0, "The parenthesis is invalid, as it is not closed."),
                    Arguments.of("))", 0, "The parenthesis is invalid, as it is not open."),
                    Arguments.of("(()", 2, "The longest valid parentheses substring is \"()\""),
                    Arguments.of("((()", 2, "The longest valid parentheses substring is \"()\""),
                    Arguments.of("(())", 4, "The longest valid parentheses substring is \"(())\""),
                    Arguments.of(")()())", 4, "The longest valid parentheses substring is \"()()\""),
                    Arguments.of("()(()", 2, "The longest valid parentheses substring is \"()\""),
                    Arguments.of("()(()()", 4, "The longest valid parentheses substring is \"()()\""),
                    Arguments.of("()()(()", 4, "The longest valid parentheses substring is \"()()\""),
                    Arguments.of("()()((()", 4, "The longest valid parentheses substring is \"()()\""),
                    Arguments.of("()((()()", 4, "The longest valid parentheses substring is \"()()\"")
            );
        }
    }

}