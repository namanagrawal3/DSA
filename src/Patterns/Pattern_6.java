package Patterns;

import java.util.Scanner;

public class Pattern_6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern6(sc.nextInt());

    }

    public static void pattern6(int row) {
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
            space+=2;
            star--;
            System.out.println();
        }
    }
}
