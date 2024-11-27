package Patterns;

import java.util.Scanner;

public class Pattern_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern10(sc.nextInt());

    }

    public static void pattern10(int row) {
        int i=1;
        int space=0;
        int star=2*row-1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            i++;
            star-=2;
            space++;
            System.out.println();
        }
    }
}
