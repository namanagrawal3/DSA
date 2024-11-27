package Patterns;

import java.util.Scanner;

public class Pattern_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern3(sc.nextInt());

    }

    public static void pattern3(int row) {
        int i=1;
        int star=row;
        while(i<=row){
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            i++;
            star--;
            System.out.println();
        }
    }
}
