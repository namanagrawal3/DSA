package Patterns;

import java.util.Scanner;

public class Pattern_20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern20(sc.nextInt());
    }

    public static void pattern20(int row) {
        int i=1;
        int space=row/2;
        int count=1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("  ");
                k++;
            }
            int j=1;
            while(j<=count){
                if(j==1 || j==count)
                    System.out.print("* ");
                else
                    System.out.print("  ");
                j++;
            }
            if(i<row/2+1){
                space--;
                count+=2;
            }
            else{
                space++;
                count-=2;
            }
            i++;
            System.out.println();
        }

    }
}
