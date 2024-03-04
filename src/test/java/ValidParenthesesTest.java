import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
class ValidParenthesesTest {

    @ParameterizedTest
    @ArgumentsSource(Source.class)
    public void itReturns(String s, Boolean expected, String message){
        assertEquals(expected, new ValidParentheses().isValid(s), message);
    }


    public static class Source implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(")", FALSE, ""),
                    Arguments.of("(", FALSE, ""),
                    Arguments.of("((", FALSE, ""),
                    Arguments.of("))", FALSE, ""),
                    Arguments.of("(()", FALSE, ""),
                    Arguments.of("((()", FALSE, ""),
                    Arguments.of("(())", TRUE, ""),
                    Arguments.of(")()())", FALSE, ""),
                    Arguments.of("()(()", FALSE, ""),
                    Arguments.of("()(()()", FALSE, ""),
                    Arguments.of("()()(()", FALSE, ""),
                    Arguments.of("()()((()", FALSE, ""),
                    Arguments.of("()((()()", FALSE, ""),
                    Arguments.of("({[]})", TRUE, "")

            );
        }
    }

}