package Patterns;

import java.util.Scanner;

public class Pattern_16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern16(sc.nextInt());

    }

    public static void pattern16(int row) {
        int i=1;
        int space=row-1;
        int star=row;
        while(i<=2*row-1){
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
            if(i<row){
                space--;
                star--;
            }
            else{
                star++;
                space++;
            }
            i++;
            System.out.println();
        }

    }
}
