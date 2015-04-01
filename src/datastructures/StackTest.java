package datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class StackTest {

    @Test
    public void testPush() throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        assertTrue(stack.size()==2);

    }

    @Test(expected = NoSuchElementException.class)
    public void testPop() throws Exception {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertTrue(stack.pop() == 1);
        assertTrue(stack.pop() == 3);
        assertTrue(stack.pop() == 2);
        stack.pop();

    }


}