package datastructures;

import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class Queue {
    //enqueue
    //dequeue
    DoublyLinkedList queue = new DoublyLinkedList();

    public void enqueue(int i)
    {
        queue.add(i);
    }

    public int dequeue(){
        if(queue.getSize()!=0){
            int returnVal= queue.getFirst().getData();
            queue.removeFirst();
            return returnVal;
        }else{
            throw new NoSuchElementException();
        }

    }

    public int size(){
        return queue.getSize();
    }

}
