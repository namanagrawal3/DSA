package Graph;

import java.util.*;

public class Graph {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public Graph(int v) {
        this.map = new HashMap<>();

        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    public boolean containsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }
    public boolean containsVertex(int v) {
        return map.containsKey(v);
    }
    public int countEdge() {
        int cnt = 0;
        for (HashMap<Integer, Integer> mp : map.values()) {
            cnt += mp.size();
        }

        return cnt/2;
    }
    public void removeEdge(int v1, int v2) {
        if (containsEdge(v1, v2)) {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }
    public void removeVertex(int v) {
        for (int nbr : map.get(v).keySet()) {
            map.get(nbr).remove(v);
        }

        map.remove(v);
    }
    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
    }
    public boolean hasPath(int src, int des, HashSet<Integer> visited) {
        if (src == des)
            return true;

        visited.add(src);

        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                boolean ans = hasPath(nbrs, des, visited);
                if (ans)
                    return true;
            }
        }
        visited.remove(src);                                  // here no need to do backtrack

        return false;
    }
    public void printAllPaths(int src, int des, HashSet<Integer> visited, String ans) {
        if (src == des) {
            System.out.println(ans + "-->" + src);
            return;
        }

        visited.add(src);

        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs))
                printAllPaths(nbrs, des, visited, ans + "-->" + src);
        }

        visited.remove(src);
    }
    public boolean bfs(int src, int des) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int rv = q.poll();                              // 1. remove
            if (visited.contains(rv))                       // 2. ignore if already visited
                continue;
            visited.add(rv);                                // 3. mark visited
            if (rv == des)
                return true;                                // 4. self work
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs))
                    q.add(nbrs);                            // 5. add unvisited nbrs in queue
            }
        }

        return false;
    }
    public boolean dfs(int src, int des) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        st.push(src);

        while (!st.isEmpty()) {
            int rv = st.pop();                              // 1. remove
            if (visited.contains(rv))                       // 2. ignore if already visited
                continue;
            visited.add(rv);                                // 3. mark visited
            if (rv == des)
                return true;                                // 4. self work
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs))
                    st.push(nbrs);                          // 5. add unvisited nbrs in queue
            }
        }

        return false;
    }
    public void bft() {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int src : map.keySet()) {
            if (visited.contains(src))
                continue;

            q.add(src);
            while (!q.isEmpty()) {
                int rv = q.poll();                              // 1. remove
                if (visited.contains(rv))                       // 2. ignore if already visited
                    continue;
                visited.add(rv);                                // 3. mark visited
                System.out.print(rv + " ");                     // 4. self work
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs))
                        q.add(nbrs);                            // 5. add unvisited nbrs in queue
                }
            }
        }
        System.out.println();
    }
    public void dft() {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for (int src : map.keySet()) {
            if (visited.contains(src))
                continue;

            st.push(src);
            while (!st.isEmpty()) {
                int rv = st.pop();                              // 1. remove
                if (visited.contains(rv))                       // 2. ignore if already visited
                    continue;
                visited.add(rv);                                // 3. mark visited
                System.out.print(rv + " ");                     // 4. self work
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs))
                        st.push(nbrs);                          // 5. add unvisited nbrs in queue
                }
            }
        }
        System.out.println();
    }
}
