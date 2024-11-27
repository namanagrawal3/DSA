package Graph;

import java.util.HashMap;

public class Disjoint_Set_Union {
    class Node {
        int val;
        int rank;
        Node parent;

    }
    private HashMap<Integer, Node> map = new HashMap<>();
    public void createSet(int v) {                   // O(1)
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v, nn);
    }
    public int findparent(int v) {
        Node p = map.get(v);
        return find(p).val;
    }
    private Node find(Node nn) {
        if (nn == nn.parent)
            return nn;

        Node pr = find(nn.parent);
        nn.parent = pr;                              // path compression  (after finding the parent the code reduces to O(1))
        return pr;
    }
    public void union(int v1, int v2) {              // union by rank (so that the height of tree do not become large)
        Node n1 = map.get(v1);
        Node n2 = map.get(v2);
        Node pr1 = find(n1);
        Node pr2 = find(n2);

        if (pr1.rank == pr2.rank) {
            pr1.parent = pr2;
            pr2.rank++;
        }
        else if (pr1.rank > pr2.rank)
            pr2.parent = pr1;
        else
            pr1.parent = pr2;
    }
}
