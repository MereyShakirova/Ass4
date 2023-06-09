# **Assignment 4 for  laboratory work for the Algorithm Data Structure**
![](https://avatars.mds.yandex.net/i?id=81aeee622298a892460bc27a41b999ac38f1bb68-2432023-images-thumbs&n=13)
### Description:
!(*All students must comply with these criteria. If the student does not comply with these criteria, the score will be lowered.
You are not allowed to use default hashing methods like Objects.hash()*)!
### In this work, these following criteria had to be done:
* Create an additional class for testing K (example: MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();)

* Create your own hashCode() method in MyTestingClass (You are not allowed to use default hashing methods like Objects.hash())

* Add random 10000 elements to your hashtable and print number of elements in each bucket (chain or linkedlist).

* Tune your hashCode method in MyTestingClass so that it does not violate the uniform distribution.
### MyHashTable:
![](https://avatars.mds.yandex.net/i?id=8ecf7a9b07abfbc6819e96b7c5de7765-7086354-images-thumbs&n=13)
#### *Explanation:*
This is a Java implementation of a Hash Table data structure. The hash table stores key-value pairs and allows efficient lookup and insertion of elements based on the key.

The code starts by defining a private inner class `HashNode` which represents a node in the hash table. Each node contains a key-value pair, as well as a reference to the next node in the chain.

The `MyHashTable` class has two constructors: one which initializes the hash table with a default size of 11, and another which allows the user to specify a custom size. The class also has several methods
#### *Here is the solution code*:
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)
        
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

### MyTestingClass:
![](https://cdn.dribbble.com/users/671650/screenshots/1803971/ab_testing_dribbble.gif)
#### *Explanation:*
This code contains two classes: MyTestingClass and Student.

The MyTestingClass class has two private fields id and name and a constructor that generates a random id and assigns it to the id field, and then creates a name string by concatenating the id with the string "Test-".

It also has a custom hashCode() method that returns the remainder of the id field divided by 11. This method is used in the MyHashTable class to determine the index of the hash table where an object of MyTestingClass type will be stored.

The Student class has two private fields name and age and a constructor that assigns a random age between 10 and 30 to the age field and a default name "John" to the name field. This class is used as the value type in the MyHashTable class, where instances of Student are stored in the hash table using instances of MyTestingClass as keys.
#### *Here is the solution code*:
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)
    
    class MyTestingClass {
        
        private int id;
        
        private String name;
        // constructor, getters, setters
        
        public MyTestingClass() {
            this.id = (int)(Math.random()*10000);
            this.name = "Test-" + id;
        }
        // custom hashCode method
        
        @Override
        public int hashCode() {
            return id % 11;
        }
    }
    
    class Student {
        private String name;
    
        private int age;
        // constructor, getters, setters
        
        public Student() {
            this.name = "Dimash Kudaibergen";
            this.age = (int)(Math.random()*20 + 10);
        }
    }


# Thank you for your attention
![screen-gif](https://i.pinimg.com/originals/8d/38/6f/8d386fe55805e14eb11db87f5acca164.gif)

![](https://media.tenor.com/rOshXzKXJBIAAAAC/waving-bye.gif)


