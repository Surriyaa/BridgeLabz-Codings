package com.stack;

import java.util.Stack;

class InfixToPostfix {
    public String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    private int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return -1;
    }

    public static void main(String[] args) {
        InfixToPostfix solution = new InfixToPostfix();
        System.out.println(solution.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // abcd^e-fgh*+^*+i-
    }
}
