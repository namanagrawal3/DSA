package Functions_n_Arrays;

public class fun_demo_1 {
    static int val = 100;
    public static void main(String[] args) {
        System.out.println("Hello");
        int a = 7;
        int b = 11;
        System.out.println(val);                    // 100
        System.out.println(addFun(a, b));
        System.out.println(val);                    // 100
    }
    public static int addFun(int a, int b) {
        int c = a + b;
        int val = 60;
        val = val + 5;                              // local variable will get modified instead of global variable
        System.out.println(val);                    // 65
        return c - subFun(c, b);
    }
    public static int subFun(int a, int b) {
        return a - b;
    }
}