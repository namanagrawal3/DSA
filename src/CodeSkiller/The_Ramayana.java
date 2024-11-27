package CodeSkiller;

public class The_Ramayana {
    public static void main(String[] args) {
        long n = 32;
        long m = 5;
        System.out.println(day(n, m));
    }
    public static long day(long n,long m){
        if(n <= m)
            return n;
        else{
            long day=m+1;
             while(n>0){
                 n -= day;
                 if(n>0)
                     n += m;
                 day++;
             }
             return day-1;
        }
    }
}
