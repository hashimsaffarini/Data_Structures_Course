package set;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet<K> {

    class HashNode {
        K key;

        HashNode(K ke) {
            this.key = key;
        }
    }

    private LinkedList<HashNode> arr[];
    private int arraySize;
    private int nodeCount;

    MyHashSet() {
        this.arraySize = 9;
        arr = new LinkedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % arraySize;
    }

    int searchIndex(K key) {
        int index = hashFunction(key);
        LinkedList<HashNode> bucket = arr[index];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    boolean loadFactorExceeded() {
        double loadFactor = (double) nodeCount / arraySize;
        return loadFactor > 0.75;
    }

    void rehash() {
        LinkedList<HashNode>[] oldArray = arr;
        arraySize *= 2;
        arr = new LinkedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = new LinkedList<>();
        }
        for (LinkedList<HashNode> bucket : oldArray) {
            for (HashNode node : bucket) {
                add(node.key);
            }
        }
    }

    void add(K key) {
        int index = hashFunction(key);
        int nodeIndex = searchIndex(key);
        if (nodeIndex == -1) {
            arr[index].add(new HashNode(key));
            nodeCount++;
        }

        if (loadFactorExceeded()) {
            rehash();
        }
    }

    boolean remove(K key) {
        int index = hashFunction(key);
        int nodeIndex = searchIndex(key);
        if (nodeIndex == -1) {
            return false;
        }
        arr[index].remove(nodeIndex);
        return true;
    }

    boolean contains(K key) {
        return searchIndex(key) != -1;
    }

}