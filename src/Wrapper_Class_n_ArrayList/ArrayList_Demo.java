package Wrapper_Class_n_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Demo {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        System.out.println(l);

        // size()
        System.out.println(l.size());

        // add()
        l.add(10);                              // Auto-Boxing
        l.add(20);                              // O(1)
        l.add(30);
        System.out.println(l);
        l.add(1,3);                // O(N) because of shifting of elements
        System.out.println(l);

        // get()                                // O(1)
        System.out.println(l.get(2));

        // remove()
        System.out.println(l.remove(2));  // O(N) because of shifting of elements
        System.out.println(l);

        // set()
        l.set(1, -30);                         // O(1)
        System.out.println(l);

        // sort
        Collections.sort(l);

        // displaying using loop
        for (int item : l) {                   // Un-Boxing
            System.out.print(item + " ");
        }
    }
}
