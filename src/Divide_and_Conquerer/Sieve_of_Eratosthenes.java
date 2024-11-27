package Divide_and_Conquerer;

public class Sieve_of_Eratosthenes {                              // Prime-Sieve Algorithm
    public static void main(String[] args) {
        int n = 100;
        boolean[] prime = new boolean[n+1];                       // Time Complexity: N*log(log(N))

        // true  --> not prime number
        // false --> prime number

        prime[0] = true;
        prime[1] = true;
        for(int i=2;i*i<=n;i++){
            if(prime[i] == false){
                for(int j=2*i;j<=n;j+=i){
                    prime[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=0;i<=n;i++){
            if(prime[i] == false) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
