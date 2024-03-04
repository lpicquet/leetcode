import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public Boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Set<Character> openingBrackets = Set.of('(', '[', '{');

        boolean isValid = true;

        for (int i=0; i<s.length(); i++){
            Character c = s.charAt(i);

            if (openingBrackets.contains(c)){
                stack.push(c);
            } else {
                // closing bracket
                // we need to see if it matches the correct one
                if (stack.isEmpty()){
                    return false;
                }
                final Character lastChar = stack.pop();
                isValid = switch (c){
                    case ')' -> lastChar == '(';
                    case ']' -> lastChar == '[';
                    case '}' -> lastChar == '{';
                    default -> false;
                };
            }
            if (!isValid){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
