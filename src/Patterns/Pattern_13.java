package Patterns;

import java.util.Scanner;

public class Pattern_13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern13(sc.nextInt());

    }

    public static void pattern13(int row) {
        int i=1;
        int star=1;
        while(i<=2*row-1){
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            if(i<row){
                star++;
            }
            else{
                star--;
            }
            i++;
            System.out.println();
        }

    }
}
