package Sliding_Window;

import java.util.Scanner;

public class Kartik_bhaiya_and_Strings {
    public static void main(String[] args) {
        String s = sc.next();
        int k = 5;

        int c1 = maxlen(s,k,'a');
        int c2 = maxlen(s,k,'b');

        System.out.println(Math.max(c1,c2));
    }
    public static int maxlen(String s,int k,char item){
        int si=0;
        int ei=0;
        int count=0;
        int len=0;
        while(ei<s.length()){
            char ch = s.charAt(ei);
            if(ch == item)
                count++;
            while(count>k && si<=ei){
                if(s.charAt(si) == item)
                    count--;
                si++;
            }
            len = Math.max(len,ei-si+1);
            ei++;
        }
        return len;
    }
}
