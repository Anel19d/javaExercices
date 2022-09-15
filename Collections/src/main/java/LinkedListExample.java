package main.java;

import java.util.LinkedList;

public class LinkedListExample {

    public static void executeLinkedListExample(){
        LinkedList<Integer> ll = new LinkedList<Integer>();

        // Appending new elements at
        // the end of the list
        for (int i = 1; i <= 5; i++) {
            ll.add(i);

        }

        ll.addFirst(0);
        ll.addLast(6);

        // Printing elements
        System.out.println(ll);
        ll.remove(3);

        System.out.println(ll);

        // Printing elements one by one
        for (int i = 0; i < ll.size(); i++){
            System.out.print(ll.get(i) + " ");
        }
    }

}
