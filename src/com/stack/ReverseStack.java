package com.stack;

import java.util.Stack;

class ReverseStack {
    public void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse(stack);
            insertAtBottom(stack, temp);
        }
    }

    private void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, item);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        ReverseStack solution = new ReverseStack();
        solution.reverse(stack);

        System.out.println(stack); // [3, 2, 1]
    }
}
