package Patterns;

import java.util.Scanner;

public class Pattern_21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern21(sc.nextInt());
    }

    public static void pattern21(int row) {
        int i=1;
        int star=1;
        int space=2*row-3;
        while(i<=row){
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            j=1;
            if(i==row){
                j=2;
            }
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            i++;
            star++;
            space-=2;
            System.out.println();
        }
    }
}
