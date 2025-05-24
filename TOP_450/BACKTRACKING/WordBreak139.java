package TOP_450.BACKTRACKING;

import java.util.*;

/*
    Problem-139: Word Break - https://leetcode.com/problems/word-break/description/
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.
        Example 1:

        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true
        Explanation: Return true because "leetcode" can be segmented as "leet code".
        Example 2:

        Input: s = "applepenapple", wordDict = ["apple","pen"]
        Output: true
        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
        Note that you are allowed to reuse a dictionary word.
        Example 3:

        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false
 */
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
//        return isWordBreak(s, new HashSet<>(wordDict), 0);
        return isWordBreakMemoization(s, new HashSet<>(wordDict));
    }

    private boolean isWordBreak(String s, Set<String> dict, int start) {
        if (start == s.length()) return true; //reached upto length of string while still segmenting
        for (int end = start; end < s.length(); end++) {
            if (dict.contains(s.substring(start, end + 1)) &&
                    isWordBreak(s, dict, end + 1)) return true;
        }
        return false;
    }

    private boolean isWordBreakMemoization(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);

        int maxLength = 0;
        // Find maximum length word in dictionary
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }

        // base case: empty string is valid
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // check prefixes of length upto to maxLen
            for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"));
        System.out.println(wordBreak139.wordBreak(s, wordDict));
    }
}
