package Recursion;

public class Letter_Combinations_of_a_Phone_Number {
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        String digits = "23";
        combination(digits,"");
    }
    public static void combination(String que,String ans){
        if(que.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        String press = map[que.charAt(0)-'0'];
        for(int i=0;i<press.length();i++){
            combination(que.substring(1),ans+press.charAt(i));
        }
    }
}
