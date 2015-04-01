package datastructures;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class Stack {

   /* DoublyLinkedList dll = new DoublyLinkedList();


    private void push(int i){
        dll.add(i);
    }

    private int pop(){
        if(dll.getSize()!=0){
            return dll.getLast().getData();
        }else{
            throw new NoSuchElementException();
        }
    }
*/


    ArrayList stack = new ArrayList();

    public void push(int i) {

        stack.add(i);
    }

    public int pop() {
        if (stack.size() != 0) {
            int retVal = stack.get(stack.size() - 1);
            stack.delete(stack.size()-1);
            return retVal;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int size(){

        return stack.size();
    }


}
