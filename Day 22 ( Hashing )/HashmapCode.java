package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashmapCode {
    public static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V val) {
                this.key = key;
                this.value = val;
            }
        }

        private static int n;// no of nodes
        private static int N;
        private LinkedList<Node> buckets[];// N = bucket.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunc(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                if (key == ll.get(i).key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[2 * N];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            // add all nodes in new buckets
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            int bi = hashFunc(key);
            int di = searchLL(key, bi);// valid , -1
            if (di != -1) {
                // update
                buckets[bi].get(di).value = value;
            } else {
                // add new node
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }

        }

        public boolean containsKey(K key) {
            int bi = hashFunc(key);
            int di = searchLL(key, bi);// valid , -1
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunc(key);
            int di = searchLL(key, bi);// valid , -1
            if (di != -1) {
                // update
                n--;
                return buckets[bi].remove(di).value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunc(key);
            int di = searchLL(key, bi);// valid , -1
            if (di != -1) {
                // update
                return buckets[bi].get(di).value;
            } else {
                return null;
            }

        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 41);
        hm.put("china", 45);
        hm.put("US", 25);
        hm.put("Nepal", 15);

        System.out.println(hm.get("china"));

        hm.containsKey("India");
        System.out.println(hm.remove("Nepal"));
        System.err.println(hm.isEmpty());
        System.out.println(hm.size());
        ArrayList<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.print(" Key = " + k + " Value = " + hm.get(k));
        }
        System.err.println();
    }
}
