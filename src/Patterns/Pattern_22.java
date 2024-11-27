package Patterns;

import java.util.Scanner;

public class Pattern_22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern22(sc.nextInt());
    }

    public static void pattern22(int row) {
        int i=1;
        int space=-1;
        int star=row;
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
            if(i==1){
                j=2;
            }
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            i++;
            space+=2;
            star--;
            System.out.println();
        }
    }
}
