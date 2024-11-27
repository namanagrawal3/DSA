package Tree;

public class Binary_Search_Tree_Client {
    public static void main(String[] args) {

        int[] inOrder = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        Binary_Search_Tree bt = new Binary_Search_Tree(inOrder);

        System.out.println(bt.max());
        System.out.println(bt.search(65));
        System.out.println(bt.search(60));
    }
}
