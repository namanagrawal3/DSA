package HashMap;

import java.util.*;

public class HashMap_Implementation<K, V> {
    class Node {
        K key;
        V value;
        Node next;
    }
    private ArrayList<Node> bucket;     // Arraylist is used because to make generic, we have to use <>, which is not supported by array
    private int size = 0;
    public HashMap_Implementation() {
        this(4);                     // constructor calling the another constructor of the same class
    }
    public HashMap_Implementation(int n) {
        bucket = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bucket.add(null);
        }
    }
    @Override
    public String toString() {
        String s = "{";
        for (Node n : bucket) {
            while (n != null) {
                s += n.key + " = " + n.value + ",";
                n = n.next;
            }
        }
        return s + "}";
    }
    public void put(K key, V value) {
        int idx = hashFun(key);
        Node temp = bucket.get(idx);
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        temp = bucket.get(idx);          // i.e, key is not present in the bucket
        Node nn = new Node();
        nn.value = value;
        nn.key = key;
        nn.next = temp;
        bucket.set(idx, nn);
        size++;

        double lf = (1.0 * size)/ bucket.size();        // Load-factor
        double tf = 2.0;                                // Threshold-factor
        if (lf > tf) {
            reHashing();
        }
    }
    private void reHashing() {
        ArrayList<Node> newBucket = new ArrayList<>();
        for (int i = 0; i < 2* bucket.size(); i++) {
            newBucket.add(null);
        }

        ArrayList<Node> old_bucket = bucket;
        bucket = newBucket;
        size = 0;
        for (Node n : old_bucket) {
            while (n != null) {
                put(n.key, n.value);
                n = n.next;
            }
        }
    }
    public boolean containsKey(K key) {
        int idx = hashFun(key);
        Node temp = bucket.get(idx);

        while (temp != null) {
            if (temp.key.equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public V get(K key) {
        int idx = hashFun(key);
        Node temp = bucket.get(idx);

        while (temp != null) {
            if (temp.key.equals(key))
                return temp.value;
            temp = temp.next;
        }
        return null;
    }
    public V remove(K key) {
        int idx = hashFun(key);
        Node temp = bucket.get(idx);
        Node prev = null;

        while (temp != null) {
            if (temp.key.equals(key))
                break;
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return null;

        if (prev == null)
            bucket.set(idx, temp.next);
        else
            prev.next = temp.next;

        size--;
        return temp.value;

    }
    public int hashFun(K key) {
        int bno = key.hashCode() % bucket.size();
        if (bno < 0)
            bno += bucket.size();
        return bno;
    }
}
