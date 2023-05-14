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
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value) {
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
    public boolean contains(V value) {
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


