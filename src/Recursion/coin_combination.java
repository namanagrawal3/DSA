package Recursion;

public class coin_combination {
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int amount = 10;
        printCombination(coins,amount,0,"",0);
    }
    public static void printCombination(int[] arr,int n,int curr,String ans,int idx){
        if(curr == n){
            System.out.print(ans+" ");;
            return;
        }
        if(curr > n)
            return;
        for(int i=idx;i<arr.length;i++){
            printCombination(arr,n,curr+arr[i],ans+arr[i],i);
        }
    }
}
