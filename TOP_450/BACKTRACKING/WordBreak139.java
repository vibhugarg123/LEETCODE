package TOP_450.BACKTRACKING;

import java.util.*;

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
        dp[0] = true;

        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            int j = i;
            while (j > 0 && (i - j + 1) <= maxLength) {
                if (dict.contains(s.substring(j - 1, i)) && dp[j - 1]) {
                    dp[i] = true;
                }
                j--;
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
