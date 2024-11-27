package Oops_2;

public class Generics_Demo_2<K, V> {           // To make a class generic, put <> after the class name and write anything inside it
    K x;
    V y;
    public Generics_Demo_2() {

    }
    public Generics_Demo_2(K x, V y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Generics_Demo_2<Integer, String> g1 = new Generics_Demo_2<>();
        Generics_Demo_2<Long, Boolean> g2 = new Generics_Demo_2<>();
    }
}
