package com.stack;

import java.util.Stack;

class BalancedParentheses {
    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedParentheses solution = new BalancedParentheses();
        System.out.println(solution.isBalanced("({[]})")); // true
        System.out.println(solution.isBalanced("({[})")); // false
    }
}
