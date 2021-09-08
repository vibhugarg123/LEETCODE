package STRINGS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class FirstUniqueCharacterString387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            count.put(currentChar, count.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterString387 firstUniqueCharacterString387=new FirstUniqueCharacterString387();
        System.out.println(firstUniqueCharacterString387.firstUniqChar("aabb"));
    }
}