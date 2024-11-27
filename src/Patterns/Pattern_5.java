package Patterns;

import java.util.Scanner;

public class Pattern_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern5(sc.nextInt());

    }

    public static void pattern5(int row) {
        int i=1;
        int space=0;
        int star=row;
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
            space++;
            star--;
            System.out.println();
        }
    }
}
