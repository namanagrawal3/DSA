package Trie_or_Prefix_Tree;

public class Maximum_XOR_of_Two_Numbers_in_an_Array {
    class Node {
        int bit;
        Node zeroChild;
        Node oneChild;
    }
    private Node root;
    public Maximum_XOR_of_Two_Numbers_in_an_Array() {
        root = new Node();
        root.bit = 2;
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.oneChild != null)
                    curr = curr.oneChild;
                else {
                    Node nn = new Node();
                    nn.bit = 1;
                    curr.oneChild = nn;
                    curr = nn;
                }
            }
            else {
                if (curr.zeroChild != null)
                    curr = curr.zeroChild;
                else {
                    Node nn = new Node();
                    nn.bit = 0;
                    curr.zeroChild = nn;
                    curr = nn;
                }
            }
        }
    }

    public int getMaxXOR(int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int currBit = (num & (1 << i)) != 0 ? 1 : 0;

            if (currBit == 1) {
                if (curr.zeroChild != null) {
                    ans += (1 << i);
                    curr = curr.zeroChild;
                }
                else
                    curr = curr.oneChild;
            }
            else {
                if (curr.oneChild != null) {
                    ans += (1 << i);
                    curr = curr.oneChild;
                }
                else
                    curr = curr.zeroChild;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};                  // Binary-Trie

        Maximum_XOR_of_Two_Numbers_in_an_Array tt = new Maximum_XOR_of_Two_Numbers_in_an_Array();
        for (int num: nums) {
            tt.insert(num);
        }

        int maxXor = 0;
        for (int num: nums) {
            maxXor = Math.max(maxXor, tt.getMaxXOR(num));
        }

        System.out.println(maxXor);
    }
}
