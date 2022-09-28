package TOP_450.ARRAYS;

/*
        Problem-344: https://leetcode.com/problems/reverse-string/
        Write a function that reverses a string. The input string is given as an array of characters s.

        You must do this by modifying the input array in-place with O(1) extra memory.

        Example 1:

        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
        Example 2:

        Input: s = ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]
         */

        /*
        Approach:
        h e l l o
        5/2=2
        0 : 4 (length-1-i)
        1 : 3 (length-1-1)
        2 : 2 (length-1-2)
 */
public class ReverseString344 {

    public void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }

    public void reverseString(char[] str) {
        for (int i = 0; i < str.length / 2; i++) {
            swap(str, i, str.length - 1 - i);
        }
    }

    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o', 'f'};
        ReverseString344 instance = new ReverseString344();
        instance.reverseString(str);
    }
}
