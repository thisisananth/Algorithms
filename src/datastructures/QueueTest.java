package datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class QueueTest {

    @Test
    public void testEnqueue() throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertTrue(queue.size()==3);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeue() throws Exception {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertTrue(queue.dequeue() == 1);
        assertTrue(queue.dequeue()==2);
        assertTrue(queue.dequeue()==3);
        queue.dequeue();

    }
}