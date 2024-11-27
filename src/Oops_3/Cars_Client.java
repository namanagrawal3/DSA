package Oops_3;

import java.util.Arrays;
import java.util.Comparator;

public class Cars_Client {
    public static void main(String[] args) {
        Cars[] arr = new Cars[5];           // till this step, no 'Cars' object has been created

        arr[0] = new Cars(2000, 1, "White");
        arr[1] = new Cars(1000, 10, "Grey");
        arr[2] = new Cars(2500, 3, "Black");
        arr[3] = new Cars(50000, 2, "Blue");
        arr[4] = new Cars(30000, 1, "Red");

        Arrays.sort(arr, new Comparator<Cars>() {                   // using Comparator interface
            @Override
            public int compare(Cars o1, Cars o2) {
                return o1.price - o2.price;
            }
        });
//        bubbleSort(arr);                                          // using Comparable interface

        display(arr);
    }
    public static void display(Cars[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    public static <T extends Comparable<T>>void bubbleSort(T[] arr) {       // setting the bound for method
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
