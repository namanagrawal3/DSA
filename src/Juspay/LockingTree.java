package Juspay;
import java.util.*;
public class LockingTree {
    HashMap<String, List<String>> map = new HashMap<>();
    HashMap<String, Integer> locked = new HashMap<>();
    HashMap<String, String> parent = new HashMap<>();
    public LockingTree(int n, int m, String[] nodes) {
        Queue<String> q = new ArrayDeque<>();           // building tree from level-order
        q.add(nodes[0]);
        int idx = 1;

        while (!q.isEmpty() && idx < n) {
            String curr = q.poll();
            List<String> children = new ArrayList<>();

            for (int i = 0; i < m && idx < n; i++) {
                String child = nodes[idx++];
                children.add(child);
                parent.put(child, curr);
                q.add(child);
            }
            map.put(curr, children);
        }
    }

    public boolean lock(String node, int user) {
        if (locked.containsKey(node))
            return false;

        // checking all the ancestors
        String anc = parent.get(node);
        while (anc != null) {
            if (locked.containsKey(anc))
                return false;
            anc = parent.get(anc);
        }

        // checking all the descendants
        Queue<String> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (locked.containsKey(curr))
                return false;

            List<String> children = map.get(curr);
            if (children != null)
                q.addAll(children);
        }

        locked.put(node, user);
        return true;
    }

    public boolean unlock(String node, int user) {
        if (locked.containsKey(node) && locked.get(node) == user) {
            locked.remove(node);
            return true;
        }
        return false;
    }

    public boolean upgrade(String node, int user) {
        if (locked.containsKey(node))
            return false;

        // checking all the ancestors
        String anc = parent.get(node);
        while (anc != null) {
            if (locked.containsKey(anc))
                return false;
            anc = parent.get(anc);
        }

        // checking all the descendants
        Queue<String> q = new ArrayDeque<>();
        q.add(node);
        boolean found = false;
        List<String> removeLocks = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (locked.containsKey(curr)) {
                if (locked.get(curr) != user)
                    return false;
                removeLocks.add(curr);
                found = true;
            }

            List<String> children = map.get(curr);
            if (children != null)
                q.addAll(children);
        }

        if (!found)
            return false;

        // unlocking the descendants
        for (String rmv: removeLocks) {
            locked.remove(rmv);
        }

        locked.put(node, user);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // number of nodes
        int m = sc.nextInt();              // children per node
        sc.nextLine();
        String[] nodes = sc.nextLine().split(" ");

        LockingTree t = new LockingTree(n, m, nodes);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            int type = Integer.parseInt(parts[0]);
            String node = parts[1];
            int uid = Integer.parseInt(parts[2]);

            boolean result = false;
            if (type == 1)
                result = t.lock(node, uid);
            else if (type == 2)
                result = t.unlock(node, uid);
            else
                result = t.upgrade(node, uid);

            System.out.println(result);
        }
    }
}
