package Heap;

import java.util.ArrayList;

public class Heap_Implement {                                       // min-heap
    private ArrayList<Integer> ll = new ArrayList<>();

    public void add(int item) {
        ll.add(item);
        upHeapify(ll.size()-1);
    }
    private void upHeapify(int ci) {
        int pi = (ci-1)/2;

        if (ll.get(pi) > ll.get(ci)) {
            swapFun(ci, pi);
            upHeapify(pi);
        }
    }
    private void swapFun(int i, int j) {
        int temp = ll.get(i);
        ll.set(i, ll.get(j));
        ll.set(j, temp);
    }
    public int remove() {
        swapFun(0, ll.size()-1);
        int rv = ll.remove(ll.size()-1);
        downHeapify(0);
        return rv;
    }
    private void downHeapify(int pi) {
        int lci = 2*pi + 1;
        int rci = 2*pi + 2;

        int mini = pi;
        if (lci < ll.size() && ll.get(mini) > ll.get(lci))
            mini = lci;
        if (rci < ll.size() && ll.get(mini) > ll.get(rci))
            mini = rci;

        if (mini != pi) {
            swapFun(mini, pi);
            downHeapify(mini);
        }
    }
    public int get() {
        return ll.get(0);
    }
    public void display() {
        System.out.println(ll);
    }
}
