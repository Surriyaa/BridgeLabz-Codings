package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            System.out.print(binary + " ");
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }
    }
    public static void main(String[] args) {
    	System.out.println("Testing Generate Binary Numbers:");
        GenerateBinaryNumbers binaryGenerator = new GenerateBinaryNumbers();
        System.out.print("Binary Numbers from 1 to 10: ");
        binaryGenerator.generateBinaryNumbers(10);  // Expected output: 1 10 11 100 101 110 111 1000 1001 1010
        System.out.println();
	}
}
