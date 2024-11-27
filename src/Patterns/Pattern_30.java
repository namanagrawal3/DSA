package Patterns;

import java.util.Scanner;

public class Pattern_30 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern30(sc.nextInt());

    }

    public static void pattern30(int row) {
        int i=1;
        int count=row;
        while(i<=row){
            int digit=row;
            int j=1;
            while(j<=count){
                System.out.print(digit-- +" ");
                j++;
            }
            i++;
            System.out.println();
        }

    }
}
