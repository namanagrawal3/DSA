package Patterns;

import java.util.Scanner;

public class Pattern_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        pattern1(sc.nextInt());

    }

    public static void pattern1(int row) {
          int i=1;
          int star=row;
          while(i<=row){
              int j=1;
              while(j<=star){
                  System.out.print("* ");
                  j++;
              }
              System.out.println();
              i++;
          }
    }
}
