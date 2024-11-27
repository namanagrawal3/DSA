package Arrays;

public class PigeonHole_Algorithm {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6};
        int n = arr.length;
        long[] fre = new long[n];
        fre[0] = 1;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            int idx = (int)sum%n;
            if(idx < 0)
                idx += n;
            fre[idx]++;
        }
        long count = 0;
        for(int i=0;i<n;i++){
            if(fre[i]>1)
                count += (fre[i]*(fre[i]-1))/2;
        }
        System.out.println(count);
    }
}
