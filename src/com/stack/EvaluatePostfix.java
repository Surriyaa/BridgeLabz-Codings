package com.stack;

import java.util.Stack;

class EvaluatePostfix {
    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluatePostfix solution = new EvaluatePostfix();
        System.out.println(solution.evaluatePostfix("231*+9-")); // -4
    }
}
