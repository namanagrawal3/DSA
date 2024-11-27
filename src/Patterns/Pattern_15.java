package Patterns;

import java.util.Scanner;

public class Pattern_15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern15(sc.nextInt());

    }

    public static void pattern15(int row) {
        int i=1;
        int space=0;
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
                space+=2;
                star--;
            }
            else{
                space-=2;
                star++;
            }
            i++;
            System.out.println();
        }

    }
}
