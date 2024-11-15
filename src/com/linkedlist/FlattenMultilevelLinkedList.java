package com.linkedlist;

class FlattenMultilevelLinkedList {
    static class Node {
        int value;
        Node next;
        Node child;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node current = head;

        while (current != null) {
            if (current.child != null) {
                Node child = current.child;
                Node temp = current.next;
                
                current.next = child;
                child.prev = current;
                
                Node childTail = child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                childTail.next = temp;
                if (temp != null) temp.prev = childTail;

                current.child = null;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.child = new Node(4);
        head.next.child.next = new Node(5);

        FlattenMultilevelLinkedList solution = new FlattenMultilevelLinkedList();
        Node result = solution.flatten(head);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
