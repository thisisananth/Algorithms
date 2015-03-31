package datastructures;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void testAdd() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertTrue(dll.getSize()==0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        assertTrue(dll.getFirst().getData()==1);
        assertTrue(dll.getLast().getData()==3);
    }

    @Test
    public void testRemove() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.remove(2);
        assertTrue(dll.getSize()==2);
        dll.remove(3);
        assertTrue(dll.getSize()==1);
        dll.remove(1);
        assertTrue(dll.getSize()==0);


    }

    @Test
    public void testAddFirst() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(1);
        assertTrue(dll.getLast().getData()==1);
        dll.add(2);
        dll.add(3);
        dll.addFirst(4);
        assertTrue(dll.getFirst().getData() == 4);


    }

    @Test
    public void testAddLast() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(1);
        assertTrue(dll.getFirst().getData()==1);
        dll.add(2);
        dll.add(3);
        dll.addLast(4);
        assertTrue(dll.getLast().getData()==4);

    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirst() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(1);
        dll.add(2);
        dll.removeFirst();

        assertTrue(dll.getFirst().getData()==2);
        dll.removeFirst();
        dll.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLast() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(1);
        dll.add(2);
        dll.removeLast();
        assertTrue(dll.getFirst().getData()==1);
        dll.removeLast();
        dll.removeLast();
    }
}