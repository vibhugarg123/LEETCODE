package TOP_450.STACK;

import java.util.Stack;

/*
   Problem- 150
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

    Note that division between two integers should truncate toward zero.

    It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.



    Example 1:

    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Example 2:

    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Solution:
       Push 4 in stack.  Stack=4
       Push 13 in stack. Stack=13,4
       Push 5 in stack. Stack=5,13,4
       Operator: "/" Pop 2 operands from stack 1st operand=5, 2nd operand=13 Evaluate: 13/5 =2
       Push 2 in stack. Stack 2,4
       Operator: "+" Pop 2 operands from stack 1st operand=2, 2nd operand=4 Evaluate: 4+2 =6

       Time Complexity:  O(N)
       Space Complexity: O(N)
 */
public class EvaluateReversePolishNotation150 {
    private boolean checkOperand(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return false;
        }
        return true;
    }

    private int eval(String operator, String operand1, String operand2) {
        switch (operator) {
            case "+":
                return Integer.parseInt(operand2) + Integer.parseInt(operand1);
            case "-":
                return Integer.parseInt(operand2) - Integer.parseInt(operand1);
            case "/":
                return Integer.parseInt(operand2) / Integer.parseInt(operand1);
            case "*":
                return Integer.parseInt(operand2) * Integer.parseInt(operand1);
        }
        return Integer.MIN_VALUE;
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (checkOperand(tokens[i])) {
                stack.push(tokens[i]);
            } else {
                if (stack.isEmpty() || stack.size() < 2) {
                    return Integer.MIN_VALUE;
                } else {
                    String operand1 = stack.pop();
                    String operand2 = stack.pop();
                    stack.push(Integer.toString(eval(tokens[i], operand1, operand2)));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation150 evaluateReversePolishNotation150 = new EvaluateReversePolishNotation150();
        System.out.println(evaluateReversePolishNotation150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}