package main.java;

import java.util.ArrayDeque;

/**
 * This is a special kind of array that
 * grows and allows users to add or remove an
 * element from both sides of the queue.
 * */
public class ArrayDequeExample {

    public static void executeArrayDeque(){
        ArrayDeque<Integer> de_que = new ArrayDeque<Integer>(10);

        // use add()
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
        de_que.add(40);
        de_que.add(50);

        System.out.println(de_que);

        // clear() method
        de_que.clear();

        // addFirst() method to insert the elements at the head
        de_que.addFirst(564);
        de_que.addFirst(291);

        // addLast()
        de_que.addLast(24);
        de_que.addLast(14);

        System.out.println(de_que);
    }
}
