package TOP_450.STRINGS;

/* Problem-5
    Given a string s, return the longest palindromic substring in s.
    Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

    Example 2:
        Input: s = "cbbd"
        Output: "bb"

    Solution:
    In fact, we could solve it in O(n^2) time complexity using only constant space.

    We observe that a palindrome mirrors around its center.
    Therefore, a palindrome can be expanded from its center, and there are only 2n - 1 such centers.

    You might be asking why there are 2n - 1 but not n centers?
    The reason is the center of a palindrome can be in between two letters.
    Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
 */

class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (null == s && s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            //when it's odd palindrome, center is i itself, hence expandAroundCenter will treat left & right same
            int len1 = expandAroundCenter(s, i, i);

            //when it's even palindrome, center is b/w i & i+1
            int len2 = expandAroundCenter(s, i, i + 1);

            //every i as center will either form odd or even palindrome.
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    // left denotes to the center of the string s && right denotes to the center+1
    private int expandAroundCenter(String s, int left, int right) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 longestPalindromicSubstring5 = new LongestPalindromicSubstring5();
        System.out.println(longestPalindromicSubstring5.longestPalindrome("cbbd"));
    }
}