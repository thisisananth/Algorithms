package datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/6/15.
 */
public class PriorityQueueTest {

    @Test
    public void testInsert() throws Exception {
               PriorityQueue pq = new PriorityQueue();
        pq.insert(5);
        pq.insert(4);
        pq.insert(6);
        pq.insert(3);
        pq.insert(8);
        pq.insert(7);
        pq.insert(1);
        pq.insert(2);
        assertTrue(pq.findMinimum() == 1);
    }

    @Test (expected = NoSuchElementException.class)
    public void testFindMinimum() throws Exception {
        PriorityQueue pq = new PriorityQueue();
        pq.findMinimum();
        pq.insert(5);
        pq.insert(4);
        pq.insert(6);
        pq.insert(3);
        pq.insert(8);
        pq.insert(7);
        pq.insert(1);
        pq.insert(-2);
        assertTrue(pq.findMinimum() == -2);

    }

    @Test
    public void testDeleteMinimum() throws Exception {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(5);
        pq.insert(4);
        pq.insert(6);
        pq.insert(3);
        pq.insert(8);
        pq.insert(7);
        pq.insert(1);
        pq.insert(-2);
        assertTrue(pq.findMinimum() == -2);
        pq.deleteMinimum();
        assertTrue(pq.findMinimum() == 1);

    }
}