/* Problem-49
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

 Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

Time Complexity: Let there be N words and each word has maximum M characters. The upper bound is O(NMLogM + MNLogN).
Space Complexity: Let number of distinct groups be N maximum where N<= Number of strings (M)
= O(N+M)
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charactersArray = str.toCharArray();
            Arrays.sort(charactersArray);
            String sortedString = new String(charactersArray);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new LinkedList<>());
            }
            map.get(sortedString).add(str);
        }
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        List<List<String>> result = groupAnagrams49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        result.forEach(System.out::println);
    }
}