import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class MyLinkedList<T> extends AbstractList<T>{

    private DoublyLinkedNode firstNode; // storing the head
    private DoublyLinkedNode lastNode; // storing the tail
    private int size; // current size of the list

    public class DoublyLinkedNode{
 
        private T item;//store an item

        private DoublyLinkedNode previous;//storing the previous node data

        private DoublyLinkedNode next; // stored the next node data

        public DoublyLinkedNode(T item,DoublyLinkedNode previous ,DoublyLinkedNode next){
            this.item = item;
            this.previous = previous;
            this.next = next;

        }


    }

    private class MyLinkedListIterator implements ListIterator<T>{

        public DoublyLinkedNode head; //current node where we are
        public DoublyLinkedNode tail;
        private int index; // each index
    
        public MyLinkedListIterator() {

            this.head = firstNode; //pass first node to be initial value 
            this.tail = lastNode;
            this.index = 0; // initial index to be 0
        }

        public boolean hasNext(){
            return this.head != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no element after " + this.head.item);
            }
            else {
                T currentItem = this.head.item;
                this.head = this.head.next;
                this.index++;
                return currentItem;
            }
        }

        

        public boolean hasPrevious() {

            return this.tail != null;
        }
        
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("There is no element before the current position");
            }
            T currentItem = tail.item;
            tail = tail.previous;
            return currentItem;
        }

        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        public void add(T item) {
            throw new UnsupportedOperationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(T item) {
            throw new UnsupportedOperationException();
        }


    }

    /*
     * The start tof the main class code
     */

    public MyLinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }


    public int size(){
        return this.size;
    }

    // Method to create a new MyLinkedListIterator
    public ListIterator<T> listIterator() {
        return new MyLinkedListIterator();
    }

    // Method to create a new MyLinkedListIterator by calling listIterator()
    public Iterator<T> iterator() {
        return listIterator();
    }


   private DoublyLinkedNode getNthNode(int index){

    DoublyLinkedNode node = this.firstNode;
    int visited = 0;
    while (visited < index && node !=null){
        //not done yet
        System.out.println("Visiting node :" + node.next.item);
        node = node.next;
        visited +=1;
    }
    return node;
   }

    public void add(int index, T item) {
        if (item == null) {
            throw new NullPointerException("Item is null and it can't add null");
        }
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index doesn't exist. Too large or too small.");
        }

        if (index == 0) {
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, null, this.firstNode);
            if (this.firstNode != null) {
                this.firstNode.previous = newNode;
            }
            this.firstNode = newNode;//updating first node to be the new node

            if (this.lastNode == null) {
                this.lastNode = newNode;
            }

        } else if (index == this.size) {
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, this.lastNode, null);
            if (this.lastNode != null) {
                this.lastNode.next = newNode; //make current tail point to new node
            }
            this.lastNode = newNode; //update tail to be new node

            if (this.firstNode == null) {
                this.firstNode = newNode;
            }
        } else {
            DoublyLinkedNode prevNode = getNthNode(index - 1);

            DoublyLinkedNode nextNode = prevNode.next;
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, prevNode, nextNode);
            prevNode.next = newNode;
            nextNode.previous = newNode;
        }

        this.size++;
    }

    public boolean add(T item){
        this.add(this.size,item);
        return true;
    }

    public T get(int index){

        if (index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("Please the position doesn't exist in the list");
        }else{

            DoublyLinkedNode node = getNthNode(index); // get item at index n
            return node.item; //return the node data
        }
    }

    public T set(int index, T item){

        T replacedItem = null;
        
        if ( item == null){
            throw new NullPointerException("Item can't be null because of node pointing to it");
        }

        if ( index >= 0 && index < this.size){
            DoublyLinkedNode node = getNthNode(index); // get the item we want to replace\
            replacedItem = node.item; //updating replaced item
            node.item = item; // update the item
            
        }else{
            throw new IndexOutOfBoundsException("No item at position " + index);
        }
        return replacedItem; //return the removed item.
        
    }

    public T remove( int index){
        System.out.println("head : " + this.firstNode.item + " tail " + this.lastNode.item);

        T removeItem = null;

        // DoublyLinkedNode currentNode = getNthNode(index);
        // DoublyLinkedNode prevNode = currentNode.previous;
        // DoublyLinkedNode sucNode = currentNode.next;


        if ( index < 0 || index >= this.size){
            // throw new IndexOutOfBoundsException("Big range becasue index is : " + index + " and  Size: " + this.size);
        }

        if ( index == 0 && this.size == 1){ //when there is only one element
            DoublyLinkedNode currentNode = getNthNode(index);
            this.firstNode = null;
            this.lastNode = null;
            this.size --;

            removeItem = currentNode.item;
        }

        if (index == 0 && this.size > 0){
            DoublyLinkedNode currentNode = getNthNode(index);
            removeItem = currentNode.item;
            this.firstNode = currentNode.next;
            currentNode.next.previous = null; // first node to have a null previous pointer

            // System.out.println("head : " + this.firstNode.item + " tail " + this.lastNode.item);
            this.size --;
        }

        if ( this.size > 1 && index == this.size - 1 ){ //removing last element
            DoublyLinkedNode currentNode = getNthNode(index);
            removeItem = currentNode.item;
            this.lastNode = currentNode.previous;//update last node to be its previous
            currentNode.previous.next = null; // make last node  next pointer be null

            // System.out.println("head : " + this.firstNode.item + " tail " + this.lastNode.item);

            this.size --;

        }

        if ( index >= 1 && index < this.size - 1){
            // System.out.println("head : " + this.firstNode.item + " tail " + this.lastNode.item);
            DoublyLinkedNode currentNode = getNthNode(index); //current node at the position
            removeItem = currentNode.item; // saving removed item
            currentNode.previous.next = currentNode.next; //update current node previous pointer to be current node's pointer
            currentNode.next.previous = currentNode.previous; //update the current node's next previous pointer to be current node's previous node.

            size --;
        }

        return removeItem;
    }

    public boolean isEmpty(){

        return this.firstNode == null; //crazy trick

    }

    public void clear() {
        while (firstNode != null) { //check if the list is not empty
            remove(0); //remove first item repetitively until first node is empty
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.add(4);
        numbers.add(6);
        numbers.add(10);


        ListIterator<Integer> iterator = numbers.listIterator();

        while ( iterator.hasNext()){
            Integer number = iterator.next();
            System.out.println(number);
        }
        
    }


    





}