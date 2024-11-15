package com.linkedlist;

class RemoveAllOccurrences {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode removeAllOccurrences(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.value == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);

        RemoveAllOccurrences solution = new RemoveAllOccurrences();
        ListNode result = solution.removeAllOccurrences(head, 6);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
