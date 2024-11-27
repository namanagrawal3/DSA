package Patterns;

import java.util.Scanner;

public class Pattern_24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern24(sc.nextInt());

    }

    public static void pattern24(int row) {
        int i=1;
        int space=row-1;
        int count=1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            int j=1;
            while(j<=count){
                System.out.print(i+" ");
                j++;
            }
            space--;
            count+=2;
            i++;
            System.out.println();
        }

    }
}
