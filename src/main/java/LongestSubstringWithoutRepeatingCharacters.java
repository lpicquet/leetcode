import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class LongestSubstringWithoutRepeatingCharacters implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        // loop through each character in the string, keep track if it's a repeated character
        Map<Character, Integer> charPos = new HashMap<>(s.length()); // keep track of the position of each character

        Integer currentSubstringLength = 0;
        Integer maximumSubstringLength = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Boolean repeated = charPos.get(c) != null;
            if (repeated) {
                // we start a new substring, all the way back from the point where the letter was last seen (example dvdf)
                System.out.println(String.format("char %s at index %d is a repeated from index %d", c, i, charPos.get(c)));
                String substring = builder.toString();
                System.out.println(String.format("The substring was %s (%d). ", substring, substring.length()));
                String subsequentString =  s.substring(charPos.get(c) +1);
                System.out.println("looking at " + subsequentString);
                Integer subsequentMaximumSubstringLength = apply(subsequentString);

                if (subsequentMaximumSubstringLength > maximumSubstringLength) {
                    maximumSubstringLength = subsequentMaximumSubstringLength;
                }
                break;
            } else {
                // the character is not repeated, we count it towards the current substring length
                System.out.println(String.format("char %s at index %d is new. ", c, i));
                builder.append(c);
                String substring = builder.toString();
                System.out.println(String.format("The substring is %s (%d). ", substring, substring.length()));
                currentSubstringLength++;
                if (currentSubstringLength > maximumSubstringLength) {
                    maximumSubstringLength = currentSubstringLength;
                }
            }
            charPos.put(c,i);
        }
        return maximumSubstringLength;
    }
}
