package TOP_450.STACK;

import java.util.Stack;

public class ValidParantheses20 {
    private Character openingBracket(Character bracket) {
        switch (bracket) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return '*';
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) return false;
                if (st.peek() != openingBracket(s.charAt(i))) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()[{)";
        System.out.println(new ValidParantheses20().isValid(s));
    }
}