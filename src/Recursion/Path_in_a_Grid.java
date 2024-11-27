package Recursion;

public class Path_in_a_Grid {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        pathFun(0,0,m-1,n-1,"");
    }
    public static void pathFun(int cr,int cc,int er,int ec,String ans){
        // cr --> curr row
        // cc --> curr col
        // er --> end row
        // ec --> end col
        if(cr==er && cc==ec){
            System.out.print(ans+" ");
            return;
        }
        if(cr>er || cc>ec)
            return;
        pathFun(cr,cc+1,er,ec,ans+"H");
        pathFun(cr+1,cc,er,ec,ans+"V");
    }
}
