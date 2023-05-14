import java.util.ArrayList;
public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private ArrayList<HashNode<K, V>>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new ArrayList[M];
        for(int i = 0; i < M; i++){
            chainArray[i] = new ArrayList<>();
        }
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new ArrayList[M];
        for(int i = 0; i < M; i++){
            chainArray[i] = new ArrayList<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value) {
        int index = hash(key);
        ArrayList<HashNode<K, V>> chain = chainArray[index];
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chain.add(newNode);
        size++;
    }
    public V get(K key){
        int index = hash(key);
        ArrayList<HashNode<K, V>> chain = chainArray[index];
        for(HashNode<K, V> node : chain){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }
public V remove(K key){
        int index = hash(key);
        ArrayList<HashNode<K, V>> chain = chainArray[index];
        for(HashNode<K, V> node : chain){
            if(node.key.equals(key)){
               chain.remove(node);
                size--;
                return node.value;
            }
        }
        return null;
}
public boolean contains(V value){
        for(ArrayList <HashNode<K, V>> chain : chainArray){
            for(HashNode<K, V> node : chain){
                if(node.value.equals(value)){
                    return true;
                }
            }
        }
        return false;
}
public K getKey(V value){
        for(ArrayList<HashNode<K, V>> chain : chainArray){
            for(HashNode<K, V> node : chain){
                if(node.value.equals(value)){
                    return node.key;
                }
            }
        }
        return null;
}

}