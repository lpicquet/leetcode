import java.util.Stack;

import static java.lang.Math.max;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> charsStack = new Stack<>();
        int maxSequenceLength = 0;

        int lastInvalidClosingBracketIndex = -1;

        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            char c = s.charAt(charIndex);
            if (c == '(') {
                charsStack.push(charIndex); // push the opening bracket
            } else {
                // closing bracket
                if (!charsStack.isEmpty()) {
                    charsStack.pop(); // remove the matching opening bracket
                    int currentSequenceLength;
                    // we either want to go back to the last invalid closing bracket or the last unclosed opening bracket
                    if (charsStack.isEmpty()) {
                        // there are no unclosed opening brackets
                        currentSequenceLength = charIndex - lastInvalidClosingBracketIndex;
                    } else {
                        currentSequenceLength = charIndex - charsStack.peek();
                    }
                    maxSequenceLength = max(maxSequenceLength, currentSequenceLength);
                } else {
                    lastInvalidClosingBracketIndex = charIndex;
                }
            }
        }


        return maxSequenceLength;
    }


    public int longestValidParenthesesFromYoutube(String s) {
        Stack<Integer> charsStack = new Stack<>();
        charsStack.push(-1); // push the initial position, which means we have not yet found an invalid bracket position

        int maxSequenceLength = 0;

        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            char c = s.charAt(charIndex);
            if (c == '(') {
                charsStack.push(charIndex); // push the opening bracket position. If it ends up being the last unclosed opening bracket, we can use it to calculate the length as it would be the last invalid opening bracket
            } else {
                // closing bracket
                charsStack.pop();

                if (charsStack.isEmpty()){
                    // we have not met a correct closing bracket so far
                    // we push the closing bracket position
                    charsStack.push(charIndex); // if it ends up being the last unmatched closing bracket, we can use it to calculate the length as it would be the last invalid closing bracket
                } else {
                    // calculate the length
                    int currentSequenceLength = charIndex - charsStack.peek(); // the stack either contains the last unclosed opening bracket or the last unmatched closing bracket
                    maxSequenceLength = max(maxSequenceLength, currentSequenceLength);
                }
            }
        }

        return maxSequenceLength;
    }

}
