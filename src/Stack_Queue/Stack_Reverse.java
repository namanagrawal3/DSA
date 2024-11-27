package Stack_Queue;
import java.util.*;

public class Stack_Reverse {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        reverseFunc(st);
        System.out.println(st);
    }
    public static void reverseFunc(Stack<Integer> st) {                             // O(N^2)
        if (st.isEmpty())
            return;
        int temp = st.pop();
        reverseFunc(st);
        insertBottom(st,temp);
    }
    public static void insertBottom(Stack<Integer> st, int item) {
        if (st.isEmpty()) {
            st.push(item);
            return;
        }
        int temp = st.pop();
        insertBottom(st,item);
        st.push(temp);
    }
}
