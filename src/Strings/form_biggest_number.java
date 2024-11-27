package Strings;

public class form_biggest_number {
    public static void main(String[] args) {
        String[] arr = {"54","546","548","60"};
        int n = arr.length;
        sort(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
    public static void sort(String[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                long a = Long.parseLong(arr[i]+arr[j]);
                long b = Long.parseLong(arr[j]+arr[i]);
                if(a < b){
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }
}
