package main.java;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {

    public static void executeTreeSet(){
        TreeSet<String> ts = new TreeSet<String>();

        ts.add("Geeks");
        ts.add("For");
        ts.add("Geeks");
        ts.add("Is");
        ts.add("Very helpful");

        // Traversing elements
        Iterator<String> itr = ts.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
