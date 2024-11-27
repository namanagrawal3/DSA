package Patterns;

import java.util.Scanner;

public class Pattern_14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern14(sc.nextInt());

    }

    public static void pattern14(int row) {
        int i=1;
        int star=1;
        int space=row-1;
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
                star++;
            }
            else{
                space++;
                star--;
            }
            i++;
            System.out.println();
        }
    }
}
