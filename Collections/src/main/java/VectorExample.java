package main.java;

import java.util.Vector;

public class VectorExample {

    public static void executeVector(){
        Vector<Integer> v = new Vector<Integer>();

        for (int i = 1; i <= 5; i++)
            v.add(i); //add element at the end

        // Printing elements
        System.out.println(v);
        // Remove element at index 3
        v.remove(3);

        // Displaying the Vector
        // after deletion
        System.out.println(v);

        // Printing elements one by one
        for (int i = 0; i < v.size(); i++)
            System.out.print(v.get(i) + " ");

    }
}
