package Basics_2;

import java.util.Scanner;

public class Pascal_triangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        pascalTri(n);
        }

    public static void pascalTri(int n) {
        int i=0;
        int count=1;
        while(i<n) {
            int j=0;
            int val=1;
            while(j<count){
                System.out.print(val+" ");
                val=(i-j)*val/(j+1);
                j++;
            }
            count++;
            i++;
            System.out.println();
        }
    }
}

