package Recursion;

public class Generate_Parenthesis {
    public static void main(String[] args) {
        int n = 3;
        generatePar(n,0,0,"");
    }
    public static void generatePar(int n,int open,int close,String ans){
        if(open==n && close==n){
            System.out.println(ans);
            return;
        }
        if(open < n)
            generatePar(n,open+1,close,ans+"(");
        if(open > close)
            generatePar(n,open,close+1,ans+")");
    }
}
