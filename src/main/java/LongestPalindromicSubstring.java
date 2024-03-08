public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            int leftmost_index = i, rightmost_index = i;

            longestPalindrome = checkPalindrome(s, leftmost_index, rightmost_index, longestPalindrome);

            // even length palindromes
            leftmost_index = i;
            rightmost_index = i + 1;
            longestPalindrome = checkPalindrome(s, leftmost_index, rightmost_index, longestPalindrome);

        }

        return longestPalindrome;
    }

    private static String checkPalindrome(String s, int leftmost_index, int rightmost_index, String longestPalindrome) {
        while (leftmost_index >= 0 && rightmost_index < s.length() && s.charAt(leftmost_index) == s.charAt(rightmost_index)) {
            int currentPalindromeLength = rightmost_index - leftmost_index + 1;
            if (currentPalindromeLength > longestPalindrome.length()) {
                longestPalindrome = s.substring(leftmost_index, rightmost_index + 1);
            }
            leftmost_index--;
            rightmost_index++;
        }
        return longestPalindrome;
    }
}
