import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashmap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>();
        System.out.println("Testing Put");
        mp.put("a", 1);
        mp.put("b", 2);
        mp.put("c", 3);
        System.out.println(mp.size());
        mp.put("c", 30);
        System.out.println(mp.size());
//        Testing Get
        System.out.println(mp.get("college"));

        System.out.println(mp.remove("c"));
        System.out.println(mp.remove("c"));
        System.out.println(mp.size());

//        Rehash
        System.out.println("Calling Rehash");
        mp.put("x", 61);
        mp.put("y", 6);
        mp.put("c", 56);

        System.out.println(mp.size());
        System.out.println(mp.get("x"));
        System.out.println(mp.get("y"));
    }

    static class MyHashMap<K, V> {
        private final int DEFAULT_CAPACITY = 4;

        private final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;

        private LinkedList<Node>[] buckets;

        private void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public MyHashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        public int size() { // return the number of entries in map
            return n;
        }

        private int HashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        //
//        Traverse the ll and look for a node with key, if found it returns its's index otherwise it return null
        //
        private int SearchInBucket(LinkedList<Node> ll, K key) {
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;
            for (var bucket : oldBuckets) {
                for (var node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = SearchInBucket(currBucket, key);
            if (ei == -1) { // key doesn't exist , we have to insert a new node
                Node node = new Node(key, value);
                currBucket.add(node);
                n++;
            } else { // Update case
                Node currNode = currBucket.get(ei);
                currNode.value = value;
            }
            if (n >= buckets.length * DEFAULT_LOAD_FACTOR) {
                rehash();
            }
        }

        public V get(K key) {
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = SearchInBucket(currBucket, key);
            if (ei != -1) {
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
//          //  Key doesn't exist

            return null;
        }

        public V remove(K key) {
            int bi = HashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = SearchInBucket(currBucket, key);
            if (ei != -1) {
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            }
//            // Key doesn't exist
            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
}
