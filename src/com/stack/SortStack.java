package com.stack;

import java.util.Stack;

class SortStack {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertSorted(stack, temp);
        }
    }

    private void insertSorted(Stack<Integer> stack, int item) {
        if (stack.isEmpty() || item > stack.peek()) {
            stack.push(item);
        } else {
            int temp = stack.pop();
            insertSorted(stack, item);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);

        SortStack solution = new SortStack();
        solution.sort(stack);

        System.out.println(stack); // [1, 2, 3]
    }
}
