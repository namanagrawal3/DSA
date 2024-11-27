package Recursion;

public class Board_Path {
    public static void main(String[] args) {
        int n = 4;
        System.out.print("\n"+jumpFun1(n,0,""));
        System.out.println();
        System.out.print("\n"+jumpFun2(n,0,""));

    }
    public static int jumpFun1(int end,int curr,String ans){
        if(curr == end){
            System.out.print(ans+" ");
            return 1;
        }
        if(curr > end)
            return 0;
        int f1 = jumpFun1(end,curr+1,ans+"1");
        int f2 = jumpFun1(end,curr+2,ans+"2");
        int f3 = jumpFun1(end,curr+3,ans+"3");
        return f1+f2+f3;
    }
    public static int jumpFun2(int end,int curr,String ans){
        if(curr == end){
            System.out.print(ans+" ");
            return 1;
        }
        if(curr > end)
            return 0;
        int count = 0;
        for(int jump=1;jump<=3;jump++){
            count += jumpFun2(end,curr+jump,ans+jump);
        }
        return count;
    }
}
