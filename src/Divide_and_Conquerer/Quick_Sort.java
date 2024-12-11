package Divide_and_Conquerer;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 0, -3, 1, 4};
        int n = arr.length;

        quickSort(arr,0,n-1);

        for (int i = 0; i < n; i++) {                       // original array is sorted itself
            System.out.print(arr[i] + " ");
        }
    }
    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei)
            return;

//        int idx = correctPosition(arr,si,ei);
        int idx = partitionFun(arr, si, ei);

        quickSort(arr, si, idx-1);
        quickSort(arr, idx+1, ei);
    }
    public static int correctPosition(int[] arr,int si,int ei){
        int item = arr[ei];
        int idx = si;
        for(int i=si;i<ei;i++){
            if(arr[i] <= item){
                int temp = arr[idx];    // swap(i,idx)
                arr[idx] = arr[i];
                arr[i] = temp;
                idx++;
            }
        }
        int temp = arr[idx];            // swap(idx,ei)
        arr[idx] = arr[ei];
        arr[ei] = temp;
        return idx;
    }
    public static int partitionFun(int[] arr, int si, int ei) {
        int i = si, j = ei;
        int pivot = arr[si];

        while (i <= j) {
            while (i <= ei && arr[i] <= pivot) {
                i++;
            }
            while (j >= si && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];   // swap(arr[i], arr[j])
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[si];          // swap(pivot, arr[j])
        arr[si] = arr[j];
        arr[j] = temp;

        return j;
    }
}
