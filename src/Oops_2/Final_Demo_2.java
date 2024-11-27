package Oops_2;

public class Final_Demo_2 {
    int x = 9;
    final int y;
    public Final_Demo_2(int x, int y) {
        this.x = x;
        this.y = y;         // since, 'y' is not initialised earlier so we can update 'y' only 1 time
    }

    public static void main(String[] args) {
        Final_Demo_2 fd1 = new Final_Demo_2(2, 9);
        System.out.println(fd1.x + " " + fd1.y);

        Final_Demo_2 fd2 = new Final_Demo_2(12, 19);
        System.out.println(fd2.x + " " + fd2.y);

    }
}
