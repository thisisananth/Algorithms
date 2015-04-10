package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void testAdd() throws Exception {
         SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.getSize()==3);
    }

    @Test
    public void testGetSize() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.getSize()==3);

    }

    @Test
    public void testRemove() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);

        assertTrue(list.getSize()==2);
        list.remove(1);
        assertTrue(list.getSize()==1);
        assertTrue(list.remove(4) == 0);
        assertTrue(list.getSize() == 1);
        list.remove(3);
        assertTrue(list.getSize()==0);


    }

    @Test
    public void testReverse() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display();
        SinglyLinkedList list2=list.reverse();
        list2.display();
    }
}