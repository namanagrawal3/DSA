package Recursion;

public class Kth_Permutation_Sequence {
    public static void main(String[] args) {
        // Way-1 ----> using recursion generate all the permutations and print the (k-1)th permutation
        // way-2 ----> using maths
        int n = 4, k = 17;
        k = k-1;
        StringBuilder s = new StringBuilder();
        StringBuilder ans  = new StringBuilder();
        for(int i=1;i<=n;i++){
            s.append(i);
        }
        while(s.length() > 1){
            int poss = fact(s.length()-1);                      // no. of permutations of each digit
            int idx = k/poss;
            ans.append(s.charAt(idx));
            s.replace(idx,idx+1,"");
            k = k%poss;
        }
        ans.append(s);
        System.out.println(ans);
    }
    public static int fact(int n){
        if(n <= 1)
            return 1;
        int ans = fact(n-1);
        return n*ans;
    }
}
