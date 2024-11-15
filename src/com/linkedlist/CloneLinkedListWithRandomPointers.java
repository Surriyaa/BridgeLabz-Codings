package com.linkedlist;

class CloneLinkedListWithRandomPointers {
    static class ListNode {
        int value;
        ListNode next;
        ListNode random;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode copy = new ListNode(curr.value);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        ListNode copyHead = head.next;
        ListNode copyCurr = copyHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.random = head.next.next;  // Random link example
        head.next.random = head;       // Random link example

        CloneLinkedListWithRandomPointers solution = new CloneLinkedListWithRandomPointers();
        ListNode clone = solution.copyRandomList(head);

        ListNode curr = clone;
        while (curr != null) {
            System.out.println("Node: " + curr.value + ", Random: " + (curr.random != null ? curr.random.value : "null"));
            curr = curr.next;
        }
    }
}
