package Oops_2;

public class Generics_Demo_1 {
    public static void main(String[] args) {
        Integer[] arr1 = {10, 20, 30, 40, 50};
        display(arr1);

        String[] arr2 = {"abc", "def", "ghi", "jkl", "mno"};
        display(arr2);
    }
    public static <T>void display(T[] arr) {               // To make the function generic, write anything inside '<>' before return type
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
