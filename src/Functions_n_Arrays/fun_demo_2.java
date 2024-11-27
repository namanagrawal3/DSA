package Functions_n_Arrays;

public class fun_demo_2 {
    static int val = 100;
    public static void main(String[] args) {
        System.out.println("Hello");
        int a = 7;
        int b = 11;
        System.out.println(val);                    // 100
        System.out.println(addFun(a, b));
        System.out.println(val);                    // 105
    }
    public static int addFun(int a, int b) {
        int c = a + b;
        int val = 60;
        fun_demo_2.val = fun_demo_2.val + 5;                              // global variable will get modified
        System.out.println(val);                    // 60
        return c;
    }
}
