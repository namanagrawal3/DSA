package Patterns;

import java.util.Scanner;

public class Pattern_31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern31(sc.nextInt());

    }

    public static void pattern31(int row) {
        int i=1;
        int count=row;
        while(i<=row){
            int digit=row;
            int j=1;
            while(j<=count){
                if(j==row+1-i){
                    System.out.print("* ");
                    digit--;
                }
                else
                    System.out.print(digit-- +" ");
                j++;
            }
            i++;
            System.out.println();
        }

    }
}
