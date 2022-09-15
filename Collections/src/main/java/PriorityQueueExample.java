package main.java;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void executePriorityQueue(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Peex to printing the top element of PriorityQueue
        System.out.println("head: "+pQueue.element());
        System.out.println("head: " + pQueue.peek());

        // Poll to printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}
