package Patterns;

import java.util.Scanner;

public class Pattern_18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern18(sc.nextInt());

    }

    public static void pattern18(int row) {
        int i=1;
        int space=row/2;
        int star=1;
        while(i<=row){
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
            if(i<row/2+1){
                space--;
                star+=2;
            }
            else{
                space++;
                star-=2;
            }
            i++;
            System.out.println();
        }

    }
}
