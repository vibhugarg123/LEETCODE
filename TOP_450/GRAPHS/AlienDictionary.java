package TOP_450.GRAPHS;

import java.util.*;

/*
    Problem- https://www.geeksforgeeks.org/problems/alien-dictionary/1
    A new alien language uses the English alphabet,
    but the order of letters is unknown.
    You are given a list of words[] from the alien language’s dictionary,
    where the words are claimed to be sorted lexicographically according to the language’s rules.

    Your task is to determine the correct order of letters in this alien
    language based on the given words. If the order is valid, return a string
    containing the unique letters in lexicographically increasing order as per the new language's rules.
    If there are multiple valid orders, return any one of them.However,
    if the given arrangement of words is inconsistent with any possible letter ordering,
    return an empty string ("").
    A string 'a' is lexicographically smaller than a string
    'b' if, at the first position where they differ,
    the character in a appears earlier in the alien language than the
    corresponding character in b. If all characters in the shorter word match the
    beginning of the longer word,
    the shorter word is considered smaller.
    Examples:

    Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
    Output: true
    Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
    The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
    The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
    The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
    The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
    So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
 */
public class AlienDictionary {
    private static final Integer N = 26;
    private HashMap<Integer, HashSet<Integer>> graph;
    private int[] indegrees;
    private boolean[] present;
    private int totalCharacters;

    public AlienDictionary() {
        this.graph = new HashMap<>();
        this.indegrees = new int[N];
        this.present = new boolean[N];
        for (int i = 0; i < N; i++) {
            present[i] = false;
        }
    }


    public boolean createGraph(String[] words) {
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!present[word.charAt(j) - 'a']) {
                    totalCharacters++;
                    present[word.charAt(j) - 'a'] = true;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int k1 = 0, k2 = 0;
            boolean canEdgeExist = false;
            while (k1 < a.length() && k2 < b.length()) {
                if (a.charAt(k1) != b.charAt(k2)) {
                    HashSet<Integer> set = graph.getOrDefault(a.charAt(k1) - 'a', new HashSet<>());
                    // Add edge only if it's not present and same increase indegree then only.
                    // set.add(x) returns true if set does not contain x, else returns false.
                    if (set.add(b.charAt(k2) - 'a')) {
                        graph.put(a.charAt(k1) - 'a', set);
                        indegrees[b.charAt(k2) - 'a']++;
                    }
                    canEdgeExist = true;
                    break;
                }
                k1++;
                k2++;
            }
            // in any dictionary, if all prefixes are same, then word of smaller length comes before
            // eg: for words abcd, abc -> correct order is abc, abcd.
            if (!canEdgeExist && a.length() - b.length() > 0) {
                // invalid dictionary order
                return false;
            }
        }
        return true;
    }

    public String findOrder(String[] words) {
        boolean isGraphValid = createGraph(words);
        if (!isGraphValid) return "";
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (present[i] && indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int nVisited = 0;
        while (!queue.isEmpty()) {
            Integer c = queue.poll();
            stringBuilder.append((char) (c + 'a'));
            nVisited++;
            if (graph.get(c) != null) {
                for (Integer i : graph.get(c)) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return nVisited == totalCharacters ? stringBuilder.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.findOrder(words));
    }
}
