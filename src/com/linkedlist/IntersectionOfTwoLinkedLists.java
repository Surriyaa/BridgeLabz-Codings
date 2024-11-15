package com.linkedlist;

import java.util.HashSet;

class IntersectionOfTwoLinkedLists {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visited.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        ListNode intersection = new ListNode(3);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);

        ListNode headB = new ListNode(5);
        headB.next = intersection;

        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode result = solution.getIntersectionNode(headA, headB);

        System.out.println("Intersection at node with value: " + (result != null ? result.value : "null"));
    }
}
