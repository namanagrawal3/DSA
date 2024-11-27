package Graph;

import java.util.*;

public class Krushkal_Algorithm {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public Krushkal_Algorithm(int vertices) {
        this.map = new HashMap<>();

        for (int i = 1; i <= vertices; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    class EdgePair {
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1, int e2, int c) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = c;
        }
        @Override
        public String toString() {
            return this.e1 + " --> " + this.e2 + " @ " + this.cost;
        }
    }
    public List<EdgePair> allEdge() {
        List<EdgePair> l = new ArrayList<>();
        for (int e1 : map.keySet()) {
            for (int e2 : map.get(e1).keySet()) {
                l.add(new EdgePair(e1, e2, map.get(e1).get(e2)));
            }
        }
        return l;
    }
    public void krushkal() {
        List<EdgePair> ll = allEdge();

        Collections.sort(ll, new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                return o1.cost - o2.cost;
            }
        });

        Disjoint_Set_Union dsu = new Disjoint_Set_Union();
        int ans = 0;

        for (int v : map.keySet()) {
            dsu.createSet(v);
        }

        for (EdgePair ed : ll) {
            int e1 = ed.e1;
            int e2 = ed.e2;
            int re1 = dsu.findparent(e1);
            int re2 = dsu.findparent(e2);

            if (re1 == re2)
                continue;
            else {
                dsu.union(e1, e2);
                System.out.println(ed);                     // printing all the edges in order
                ans += ed.cost;
            }
        }

        System.out.println(ans);                            // cost of minimum spanning tree
    }

    public static void main(String[] args) {
        Krushkal_Algorithm ka = new Krushkal_Algorithm(7);

        ka.addEdge(1, 2, 3);
        ka.addEdge(1, 4, 4);
        ka.addEdge(2, 3, 5);
        ka.addEdge(3, 4, 6);
        ka.addEdge(4, 5, 8);
        ka.addEdge(5, 6, 2);
        ka.addEdge(5, 7, 1);
        ka.addEdge(6, 7, 9);

        ka.krushkal();


    }
}
