package Basics_2;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dividend= sc.nextInt();
        int divisor= sc.nextInt();
        System.out.println(gcd1(dividend,divisor));
        System.out.println(gcd2(dividend,divisor));
    }
    public static int gcd1(int dividend,int divisor){
        while(dividend % divisor !=0){
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        return divisor;
    }
    public static int gcd2(int dividend,int divisor){
        int hcf=1;
        for(int i=Math.min(dividend,divisor);i>=1;i--){
            if(dividend%i==0 && divisor%i==0){
                hcf=i;
                break;
            }
        }
        return hcf;
    }
}
