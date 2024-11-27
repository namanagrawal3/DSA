package Recursion;

public class Permutation_2 {
    public static void main(String[] args) {
        String st = "aba";
        printPermutation(st,"");
        System.out.println();
        uniquePermutation(st,"");
    }
    public static void printPermutation(String que,String ans){
        if(que.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<que.length();i++){
            char ch = que.charAt(i);
            String QUE = que.substring(0,i) + que.substring(i+1);
            printPermutation(QUE,ans+ch);
        }
    }
    public static void uniquePermutation(String que,String ans){
        if(que.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<que.length();i++){
            char ch = que.charAt(i);
            boolean flag = true;
            for(int j=i+1;j<que.length();j++){
                if(que.charAt(j) == ch){
                    flag = false;
                    break;
                }
            }
            if(flag){
                String QUE = que.substring(0,i) + que.substring(i+1);
                uniquePermutation(QUE,ans+ch);
            }
        }
    }
}
