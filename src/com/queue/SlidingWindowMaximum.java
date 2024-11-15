package com.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements in window
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
    public static void main(String[] args) {
    	 System.out.println("Testing Sliding Window Maximum:");
         SlidingWindowMaximum slidingWindow = new SlidingWindowMaximum();
         int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
         int[] result = slidingWindow.maxSlidingWindow(nums, 3);
         System.out.print("Sliding Window Maximum: ");
         for (int val : result) {
             System.out.print(val + " ");  // Expected output: 3 3 5 5 6 7
         }
         System.out.println();
         
	}
}
