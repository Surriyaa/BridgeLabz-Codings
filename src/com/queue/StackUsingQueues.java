package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Push element to stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop element from stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element of queue1 is the top of the stack
        int top = queue1.poll();

        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int top = queue1.peek();
        queue2.add(queue1.poll());

        // Swap references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    public static void main(String[] args) {
        
        // 1. Test Stack Using Queues
        System.out.println("Testing Stack Using Queues:");
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(10);
        stack.push(20);
        System.out.println("Top of stack: " + stack.top());  // Should print 20
        System.out.println("Popped from stack: " + stack.pop());  // Should print 20
        System.out.println("Stack empty: " + stack.isEmpty());  // Should print false
        System.out.println();
    }
}
