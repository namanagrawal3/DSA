package Patterns;

import java.util.Scanner;

public class Pattern_17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern17(sc.nextInt());

    }

    public static void pattern17(int row) {
        int i=1;
        int star=row/2;
        int space=1;
        while(i<=row){
            int j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            j=1;
            while(j<=star){
                System.out.print("* ");
                j++;
            }
            if(i<row/2+1){
                star--;
                space+=2;
            }
            else{
                star++;
                space-=2;
            }
            i++;
            System.out.println();
        }
    }
}
