import static org.junit.Assert.assertEquals;

import java.util.ListIterator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    void testSize() {

        MyLinkedList<String> list = new MyLinkedList<>();

        int size = list.size();
        assertEquals(0,size);
    }

    @Test
    void testAdd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0,10);  
        list.add(1,100);
        list.add(2,1000);
        list.add(1,0);

        int size = list.size();

        int item0 = list.get(0);

        int item1 = list.get(1);
        int item2 = list.get(2);

        assertEquals(4,size);

        assertEquals(10,item0);
        assertEquals(0,item1);
        assertEquals(100,item2);

    }

    @Test
    void testSet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(20);

        int add0 = list.get(0);
        int add2 = list.get(2);


        int item0 = list.set(0, 2); //return what has been replaced at index 0
        int item2 = list.set(2, 30);//return what has been replaced at index 2


        list.set(0,2); //update items at 0
        list.set(2,30); //update items at 2
        list.set(0,null);

        int get0 = list.get(0); // get new item at index 0
        int get2 = list.get(2);//get new item at index 2

        assertEquals(5,add0); //original item at 0
        assertEquals(20,add2);//original item at 2

        assertEquals(item0, add0); //get what is replaced / original item
        assertEquals(item2, add2);

        assertEquals(get0, 2); // check what changed
        assertEquals(get2, 30);

        
    }

    @Test
    void testClear() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(9);
        list.add(1);
        
        int currentSize = list.size();
        assertEquals(3,currentSize);


        list.clear();
        int newSize = list.size();

        assertEquals(0,newSize);
        assertEquals(true,list.isEmpty());
        
    }

    @Test
    void testIsEmpty() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(9);
        list.add(1);

        assertEquals(false,list.isEmpty());

        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        assertEquals(true, list2.isEmpty());



        
    }

    @Test
    void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(9);
        list.add(1);

        int removed = list.remove(0);
        assertEquals(5,removed);
        assertEquals(2, list.size());
        
    }


    @Test
    void testListIterator() {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(20);

        list.listIterator();

        ListIterator<Integer> iterator = list.listIterator();
        // ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();


        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());


        assertTrue(iterator.hasPrevious());
        assertEquals(20, iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals(6, iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals(5, iterator.previous());
        assertFalse(iterator.hasPrevious());


        
    }
}