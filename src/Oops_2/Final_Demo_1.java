package Oops_2;

public class Final_Demo_1 {
    int x = 9;
    final int y = 2;
    public Final_Demo_1(int x, int y) {
        this.x = x;
//        this.y = y;                       // we can not re-initialised 'y' because of final keyword
    }

    public static void main(String[] args) {
        Final_Demo_1 fd = new Final_Demo_1(12, 9);
        System.out.println(fd.x + " " + fd.y);

    }
}
