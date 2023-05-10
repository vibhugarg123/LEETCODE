package TOP_450.STRINGS;

import java.util.Stack;

/*
       Problem: 402: https://leetcode.com/problems/remove-k-digits/
       Remove K digits to build the lowest possible number.
 */

public class RemoveKDigitsBuildLowestNumber {
    public String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        if (k >= num.length()) return "0";

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            // Removing all digits in stack that are greater
            // than this digit(since they have higher weightage)
            while (!st.isEmpty() && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            }
            // ignore pushing 0 i.e if stack is empty and character is 0, don't push it.
            if (!st.isEmpty() || num.charAt(i) != '0') {
                st.push(num.charAt(i));
            }
        }

        // If our k isn't 0 yet, then we keep popping out the stack until k becomes 0
        // Case: ascending order like "123", since it's in ascending order, all characters will be pushed to stack, but we need to remove k,
        // hence popping up k characters from the stack until k=0;
        while (!st.isEmpty() && k > 0) {
            k--;
            st.pop();
        }

        if (st.isEmpty())
            return "0";

        StringBuilder response = new StringBuilder();
        while (!st.isEmpty()) {
            Character c = st.pop();
            response.append(c);
        }
        // reverse the string to return the output
        response.reverse();
        return response.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(new RemoveKDigitsBuildLowestNumber().removeKdigits(num, k));
    }
}