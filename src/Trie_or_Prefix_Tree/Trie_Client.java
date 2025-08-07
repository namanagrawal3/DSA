package Trie_or_Prefix_Tree;

public class Trie_Client {
    public static void main(String[] args) {
        Trie tt = new Trie();
        tt.insert("raj");
        tt.insert("go");
        tt.insert("mango");
        tt.insert("raju");
        tt.insert("man");
        tt.insert("gold");

        System.out.println(tt.search("man"));
        System.out.println(tt.search("mangoes"));
        System.out.println(tt.startWith("man"));
    }
}
