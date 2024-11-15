package com.linkedlist;

class ReorderList {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = reverseList(slow.next);
        slow.next = null;  // Split the list into two halves

        // Step 3: Merge the two halves
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        // Print reordered list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }
}
