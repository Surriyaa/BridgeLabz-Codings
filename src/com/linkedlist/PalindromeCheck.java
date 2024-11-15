package com.linkedlist;

import java.util.Stack;

class PalindromeCheck {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.value);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.value != stack.pop()) return false;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeCheck solution = new PalindromeCheck();
        System.out.println("Is palindrome: " + solution.isPalindrome(head));
    }
}
