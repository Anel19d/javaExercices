package main.java;

import java.util.ArrayList;

public class ArrayListExample {


    public static void executeArrayExample(){

        ArrayList<Integer> al = new ArrayList <Integer>();

        ArrayList<Integer> newAl = new ArrayList <Integer>();

        for(int i = 1; i <= 5; i++){
            al.add(i);
            newAl.add(i);
        }
        System.out.println("Print all the elements: ");
        System.out.println(al);

        System.out.println("Remove element at index 3: ");
        al.remove(3);
        System.out.println(al);

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println("Print all the elements with newones: ");
        al.addAll(newAl);

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}
