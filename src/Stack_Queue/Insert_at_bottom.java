package Stack_Queue;

import java.util.Stack;

public class Insert_at_bottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        int item = -2;
        insertBottom(st,item);
        System.out.println(st);
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
