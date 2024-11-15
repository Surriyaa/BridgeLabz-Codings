package com.queue;

import java.util.*;

class PrintJob {
    int id;
    int priority;

    public PrintJob(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class PrinterQueueSimulation {
    public void simulatePrinterQueue(List<PrintJob> jobs) {
        Queue<PrintJob> queue = new LinkedList<>(jobs);
        while (!queue.isEmpty()) {
            PrintJob job = queue.poll();
            System.out.println("Printing job with ID: " + job.id + " and Priority: " + job.priority);
        }
    }
    public static void main(String[] args) {
    	 System.out.println("Testing Printer Queue Simulation:");
         PrintJob job1 = new PrintJob(1, 1);
         PrintJob job2 = new PrintJob(2, 3);
         PrintJob job3 = new PrintJob(3, 2);
         PrintJob job4 = new PrintJob(4, 4);
         
         PrinterQueueSimulation printerQueueSimulation = new PrinterQueueSimulation();
         printerQueueSimulation.simulatePrinterQueue(java.util.Arrays.asList(job1, job2, job3, job4));
         System.out.println();

	}
}
