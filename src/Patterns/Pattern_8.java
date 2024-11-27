package Patterns;

import java.util.Scanner;

public class Pattern_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern8(sc.nextInt());

    }

    public static void pattern8(int row) {
        int i=0;
        while(i<row){
            int j=0;
            while(j<row){
                if(i==j || i+j==row-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
