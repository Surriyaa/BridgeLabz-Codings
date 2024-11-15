package com.stack;

import java.util.Stack;

class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        int[] nums = {4, 5, 2, 25};
        int[] result = solution.nextGreaterElement(nums);
        for (int r : result) System.out.print(r + " "); // 5 25 25 -1
    }
}
