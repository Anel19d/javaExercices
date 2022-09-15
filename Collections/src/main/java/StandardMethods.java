package main.java;

import java.util.*;
import java.lang.Integer;
public class StandardMethods {

    public static void executeVectorExample() {
        // Creating instances of the array,
        // vector and hashtable
        int arr[] = new int[] { 1, 2, 3, 4 };
        Vector<Integer> v = new Vector();
        Hashtable<Integer, String> h = new Hashtable();

        // Adding the elements into the
        // vector
        v.addElement(1);
        v.addElement(2);

        // Adding the element into the
        // hashtable
        h.put(1, "geeks");
        h.put(2, "4geeks");

        // Accessing the first element of the
        // array, vector and hashtable
        System.out.println("Printing array: "+ arr[0]);  // Array elements are accessed using [],
        System.out.println("Printing vector: "+ v.elementAt(0)); // vector elements using elementAt()
        System.out.println("Printing hashtable: "+ h.get(1)); // and hashtable elements using get()

    }

}
