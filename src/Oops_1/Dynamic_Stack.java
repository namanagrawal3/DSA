package Oops_1;

public class Dynamic_Stack extends Stack {
    @Override
    public void push(int item) throws Exception {
        if (isFull()) {
            int[] arr = new int[2 * this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                arr[i] = this.data[i];
            }
            this.data = arr;
        }
        super.push(item);
    }

    public static void main(String[] args) throws Exception {
        Dynamic_Stack ds = new Dynamic_Stack();
        ds.push(10);
        ds.push(20);
        ds.push(30);
        ds.push(40);
        ds.push(50);
        ds.push(60);
        ds.push(70);
        ds.display();
    }
}
