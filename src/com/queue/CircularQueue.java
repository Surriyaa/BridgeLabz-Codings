package com.queue;

public class CircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        if (front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = item;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Get front element
    public int front() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
    public static void main(String[] args) {
    	System.out.println("Testing Circular Queue:");
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        System.out.println("Dequeued from circular queue: " + circularQueue.dequeue());  // Should print 1
        circularQueue.enqueue(6);
        System.out.println("Front of circular queue: " + circularQueue.front());  // Should print 2
        System.out.println();
	}
}
