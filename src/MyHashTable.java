
// hash: This is a private method which calculates the hash value of a given key using the hashCode() method of the key object.

// put: This method inserts a new key-value pair into the hash table. It first calculates the bucket index using the hash() method, then iterates through the chain at that index until it finds the node with the given key. If the key already exists in the chain, its value is updated. Otherwise, a new node is created and added to the chain.

// get: This method retrieves the value associated with a given key from the hash table. It first calculates the bucket index using the hash() method, then iterates through the chain at that index until it finds the node with the given key. If the key is found, its value is returned. Otherwise, null is returned.

// remove: This method removes the key-value pair with the given key from the hash table. It first calculates the bucket index using the hash() method, then iterates through the chain at that index until it finds the node with the given key. If the key is found, the node is removed from the chain and its value is returned. Otherwise, null is returned.

// contains: This method checks whether the hash table contains a given value. It iterates through all the chains in the hash table and checks each node's value. If the value is found, true is returned. Otherwise, false is returned.

// getKey: This method retrieves the key associated with a given value from the hash table. It iterates through all the chains in the hash table and checks each node's value. If the value is found, its key is returned. Otherwise, null is returned.

import java.util.ArrayList;
import java.util.List;

public class MyHashTable<K, V> {
    private static class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable() {
        chainArray = (HashNode<K, V>[]) new HashNode[M];
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = (HashNode<K, V>[]) new HashNode[M];
    }
    private int hash(K key) {
        //calculates the hash value of a given key using the hashCode() method of the key object
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value) {
        //inserts a new key-value pair into the hash table
        int bucketIndex = hash(key);
        HashNode<K, V> node = chainArray[bucketIndex];
        while(node != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[bucketIndex];
        chainArray[bucketIndex] = newNode;
        size++;
    }
    public V get(K key) {
        //retrieves the value associated with a given key from the hash table
        int bucketIndex = hash(key);
        HashNode<K, V> node = chainArray[bucketIndex];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key) {
        //removes the key-value pair with the given key from the hash table.
        int bucketIndex = hash(key);
        HashNode<K, V> node = chainArray[bucketIndex];
        HashNode<K, V> prev = null;
        while(node != null){
            if(node.key.equals(key)){
                if(prev == null){
                    chainArray[bucketIndex] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value) {//checks whether the hash table contains a given value
        for(int i=0; i<M; i++){
            HashNode<K, V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        //retrieves the key associated with a given value from the hash table
        for(int i=0; i<M; i++){
            HashNode<K, V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        for(int i=0; i<10000; i++) {
            MyTestingClass key = new MyTestingClass();
            Student value = new Student();
            table.put(key, value);
        }
        List<Integer> bucketSizes = new ArrayList<>();
        for(int i=0; i<table.chainArray.length; i++) {
            HashNode<MyTestingClass, Student> node = table.chainArray[i];
            int size = 0;
            while(node != null) {
                size++;
                node = node.next;
            }
            bucketSizes.add(size);
        }
        System.out.println("Bucket Sizes: " + bucketSizes);
    }
}


