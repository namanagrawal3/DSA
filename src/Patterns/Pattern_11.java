package Patterns;

import java.util.Scanner;

public class Pattern_11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern11(sc.nextInt());

    }

    public static void pattern11(int row) {
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
                if(j%2==0)
                    System.out.print("  ");
                else
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
