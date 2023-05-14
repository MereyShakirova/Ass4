# **Assignment 4 for  laboratory work for the Algorithm Data Structure**
![](https://avatars.mds.yandex.net/i?id=81aeee622298a892460bc27a41b999ac38f1bb68-2432023-images-thumbs&n=13)
### Description:
!(*If the students haven't implemented their own MyLinkedList and MyArrayList classes, they can use the built-in LinkedList and ArrayList classes provided by Java.*)!
!()
## **Implement MyHashTable class.**

![]()
### In MyArrayListStack and MyLinkedListStack, the following tasks had to be done:

*1. Create a new class named MyLinkedListStack for the MyLinkedList implementation or MyArrayListStack for the MyArrayList implementation.*

*2. Import the necessary classes: java.util.EmptyStackException for the stack exceptions, and MyLinkedList or MyArrayList from the previous tasks.*

*3. Declare an instance variable of type MyLinkedList or MyArrayList inside the class.*

*4. Create a constructor for the class and initialize the instance variable.*

*5. Implement the push method that adds an element to the top of the stack using the addFirst method for MyLinkedList or add method for MyArrayList.*

*6. Implement the pop method that removes and returns the top element of the stack using the removeFirst method for MyLinkedList or remove method for MyArrayList.*

*7. Implement the peek method that returns the top element of the stack without removing it using the getFirst method for MyLinkedList or get method for MyArrayList.*

*8. Implement the isEmpty method that returns true if the stack is empty or false if it is not using the isEmpty method for MyLinkedList or MyArrayList.*

*9. Implement the size method that returns the number of elements in the stack using the size method for MyLinkedList or MyArrayList.*

### MyArrayListStack.java:
#### *Explanation:*

Firstly, I created a stack class using MyArrayList for implementation. Then I am importing java.util.EmptyStackException since I will be using this exception to throw when the stack is empty. I declared a variable MyArrayList. Thirdly, created a constructor for the class and initialize the instance variable. In the last, I implemented push, pop, peek, isEmpty, size. Then at the end, using the Main class, I tested the code for class MyArrayListStack.

#### *Here is the solution code*:
        import java.util.ArrayList;
        import java.util.EmptyStackException;
        public class MyArrayListStack<T> {
        private ArrayList<T> stack;
            public MyArrayListStack() {
                stack =new ArrayList<>();
            }
            public void push(T element){
                stack.add(element);
            }
    
            public T pop(){
                if(stack.isEmpty()) {
                    throw new EmptyStackException();
                }
                return stack.remove(stack.size() - 1);
            }
            public T peek(){
                if(stack.isEmpty()){
                    throw new EmptyStackException();
                }
                return stack.get(stack.size()-1);
            }
            public boolean isEmpty(int T){
                return stack.isEmpty();
            }
            public int size() {
                return stack.size();
            }

        }



### MyLinkedListStack.java:
#### *Explanation:*

Firstly, I created a stack class using MyLinkedList for implementation. Then I am importing java.util.EmptyStackException since I will be using this exception to throw when the stack is empty. I declared a variable MyLinkedList. Thirdly, created a constructor for the class and initialize the instance variable. In the last, I implemented push, pop, peek, isEmpty, size. Then at the end, using the Main class, I tested the code for class MyLinkedListStack.

#### *Here is the solution code*:
        import java.util.EmptyStackException;
        import java.util.LinkedList;
        public class MyLinkedListStack<T> {
        private LinkedList<T> stack;
            public MyLinkedListStack(){
                stack = new LinkedList<>();
            }
            public void push(T element) {
                stack.addFirst(element);
            }
            public T pop(){
                if(stack.isEmpty()){
                    throw new EmptyStackException();
                }
                return stack.removeFirst();
            }
            public T peek(){
                if(stack.isEmpty()){
                    throw new EmptyStackException();
            }
                return stack.getFirst();
            }
            public boolean isEmpty(){
                return stack.isEmpty();
            }
            public int size(){
                return stack.size();
            }
            
        }


## **Queue Implementation**
![Assignment 3](https://tse3.mm.bing.net/th?id=OIP.ojQqXtfstcULPnw1aAaapgHaEK&pid=15.1)
### In MyArrayListQueue and MyLinkedListQueue the following tasks had to be done:

*1. Create a new class named MyLinkedListQueue for the MyLinkedList implementation or MyArrayListQueue for the MyArrayList implementation.*

*2. Import the necessary classes: java.util.NoSuchElementException for the queue exceptions, and MyLinkedList or MyArrayList from the previous tasks.*

*3. Declare an instance variable of type MyLinkedList or MyArrayList inside the class.*

*4. Create a constructor for the class and initialize the instance variable.*

*5. Implement the enqueue method that adds an element to the back of the queue using the addLast method for MyLinkedList or add method for MyArrayList.*

*6. Implement the dequeue method that removes and returns the front element of the queue using the removeFirst method for MyLinkedList or remove method for MyArrayList.*

*7. Implement the peek method that returns the front element of the queue without removing it using the getFirst method for MyLinkedList or get method for MyArrayList.*

*8. Implement the isEmpty method that returns true if the queue is empty or false if it is not using the isEmpty method for MyLinkedList or MyArrayList.*

*9. Implement the size method that returns the number of elements in the queue using the size method for MyLinkedList or MyArrayList.*

### MyArrayListQueque.java:
#### *Explanation:*

The MyArrayListQueue class uses generics to allow elements of any type to be used in the queue. The MyArrayListQueue class implements a stack. The MyArrayListQueue class uses the add method to add an element to the end of the queue, and the remove method at index 0 to remove an element from the head of the queue. The peek method is implemented similarly to the stack implementation. The isEmpty and size methods are also implemented. MyArrayListQueue throws a NoSuchElementException if dequeuing or browsing is called on an empty queue.

#### *Here is the solution code*:
    import java.util.ArrayList;
    import java.util.NoSuchElementException;
    public class MyArrayListQueque<T> {
        private ArrayList<T> queue;
        public MyArrayListQueque() {
            queue = new ArrayList<>();
        }
        public void enqueue(T element){
            queue.add(element);
        }
        public T dequeue(){
            if(queue.isEmpty()){
                throw new NoSuchElementException();
        }
            return queue.remove(0);
        }
        public T peek() {
            if(queue.isEmpty()){
                throw new NoSuchElementException();
        }
            return queue.get(0);
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
        public int size(){
            return queue.size();
        }
        
    }



### MyLinkedListQueque.java:
#### *Explanation:*

Firstly, I created a MyLinkedListQueue class that uses generics to allow any type of element in the queue and implements a stack. Then I imported java.util.EmptyElementException since I will be using this exception to throw when the stack is empty. I declared a variable MyLinkedList. Thirdly, created a constructor for the class and initialized the instance variable. In the latter, I implemented push, pop, peek, isEmpty, size. Then, at the end, using the Main class, I tested the MyLinkedQueque class code.

#### *Here is the solution code*:
    import java.util.LinkedList;
    import java.util.NoSuchElementException;
    public class MyLinkedListQueque<T> {
        private LinkedList<T> queue;
        public MyLinkedListQueque() {
            queue = new LinkedList<>();
        }
        public void enqueue(T element){
            queue.addLast(element);
        }
        public T dequeue() {
            if(queue.isEmpty()){
                throw new NoSuchElementException();
        }
            return queue.removeFirst();
        }
        public T peek(){
            if(queue.isEmpty()){
                throw new NoSuchElementException();
        }
            return queue.getFirst();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
        public int size(){
            return queue.size();
        }
    }

## Main class:
*In Main class I tested the code with different way, like push, pop and so on to test, prove the code*
#### *Here is the test code:*
        public class Main {
        public static void main(String[] args) {
                
                System.out.println("Testing MyArrayListStack:");
                MyArrayListStack<Integer> arrayListStack = new MyArrayListStack<>();
                arrayListStack.push(11);
                arrayListStack.push(21);
                arrayListStack.push(31);
                System.out.println(arrayListStack.pop());//31
                System.out.println(arrayListStack.peek());//21
                System.out.println(arrayListStack.size());//2
        
                System.out.println("Testing MyLinkedListStack:");
                MyLinkedListStack<Integer> linkedListStack =  new MyLinkedListStack<>();
                linkedListStack.push(4);
                linkedListStack.push(5);
                linkedListStack.push(11);
                linkedListStack.push(7);
                System.out.println(linkedListStack.pop());//7
                linkedListStack.push(13);
                System.out.println(linkedListStack.pop());//13
                System.out.println(linkedListStack.peek());//11
                System.out.println(linkedListStack.size());//3
        
        
                System.out.println("Testing MyArrayListQueque:");
                MyArrayListQueque<String> myArrayListQueque = new MyArrayListQueque<>();
                myArrayListQueque.enqueue("qwerty");
                myArrayListQueque.enqueue("asdfg");
                myArrayListQueque.enqueue("zxcvb");
                System.out.println(myArrayListQueque.isEmpty());//false
                System.out.println(myArrayListQueque.size());//3
                System.out.println(myArrayListQueque.peek());//qwerty
                System.out.println(myArrayListQueque.dequeue());//qwerty
        
        
                System.out.println("Testing MyArrayListQueque:");
                MyLinkedListQueque<String> myLinkedListQueque = new MyLinkedListQueque<>();
                myLinkedListQueque.enqueue("Gryffindor");
                myLinkedListQueque.enqueue("Slytherin");
                myLinkedListQueque.enqueue("Hufflepuff");
                myLinkedListQueque.enqueue("Ravenclaw");
                System.out.println(myLinkedListQueque.isEmpty());//false
                System.out.println(myLinkedListQueque.size());//4
                System.out.println(myLinkedListQueque.peek());//Gryffindor
                System.out.println(myLinkedListQueque.dequeue());//Gryffindor
                System.out.println(myLinkedListQueque.dequeue());//Slytherin
                System.out.println(myLinkedListQueque.dequeue());//Hufflepuff
                System.out.println(myLinkedListQueque.dequeue());//Ravenclaw
                System.out.println(myLinkedListQueque.isEmpty());//true
            }
        }


