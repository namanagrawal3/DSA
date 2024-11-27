package Patterns;

import java.util.Scanner;

public class Pattern_9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern9(sc.nextInt());
    }

    public static void pattern9(int row) {
        int i=1;
        int space=row-1;
        int star=1;
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
            space--;
            star+=2;
            System.out.println();
        }
    }
}
