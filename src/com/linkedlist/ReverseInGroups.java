package com.linkedlist;

class ReverseInGroups {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverseInGroups(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        // Reverse first k nodes of the linked list
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseInGroups solution = new ReverseInGroups();
        ListNode result = solution.reverseInGroups(head, 2);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
