package Basics_2;

import java.util.Scanner;

public class Binary_conversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(deciToBin(n));
    }

    public static int deciToBin(int n) {
        int sum=0;
        int mul=1;
        while(n>0){
            int rem = n%2;
            n/=2;
            sum += rem*mul;
            mul*=10;
        }
        return sum;
    }
}
