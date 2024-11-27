package Patterns;

import java.util.Scanner;

public class Pattern_25 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern25(sc.nextInt());

    }

    public static void pattern25(int row) {
        int i=1;
        int count=1;
        int digit=1;
        int space=row-1;
        while(i<=row){
            int k=1;
            while(k<=space){
                System.out.print("   ");
                k++;
            }
            int j=1;
            while(j<=digit){
                if((int)Math.log10(count)+1==1)
                    System.out.print(count++ +"  ");
                else
                    System.out.print(count++ +" ");
                j++;
            }
            i++;
            space--;
            digit+=2;
            System.out.println();
        }
    }
}
