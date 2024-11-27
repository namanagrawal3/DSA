package Patterns;

import java.util.Scanner;

public class Pattern_7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern7(sc.nextInt());

    }

    public static void pattern7(int row) {
        int i=1;
        int star=row;
        int space=row-2;
        while(i<=row){
            if(i==1 || i==row){
                int j=1;
                while(j<=star){
                    System.out.print("* ");
                    j++;
                }
            }
            else{
                System.out.print("* ");
                int k=1;
                while(k<=space){
                    System.out.print("  ");
                    k++;
                }
                System.out.print("* ");
            }
            i++;
            System.out.println();
        }
    }
}
