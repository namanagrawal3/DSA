package Tree;

public class BinaryTree_Client {
    public static void main(String[] args) {
        // input : 10 true 20 true 40 false false true 30 false false true 60 false false

        BinaryTree bt = new BinaryTree();

        bt.display();
        System.out.println();

        System.out.println(bt.findMax());
        System.out.println(bt.find(50));
        System.out.println(bt.heightOfTree());
        System.out.println();

        bt.preOrderTraverse();
        bt.inOrderTraverse();
        bt.postOrderTraverse();
        bt.levelOrderTraverse();
    }
}
