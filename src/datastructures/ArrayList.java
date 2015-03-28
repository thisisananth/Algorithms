package datastructures;

import java.util.Arrays;

/**
 * Created by ananthmajumdar on 3/28/15.
 *
 */
public class ArrayList {

    //Arraylist provides access to an infinite list using arrays internally.
    //here I will implement int arraylist methods add,get and remove


    private int size=0;
    private int INITIAL_CAPACITY=10;
    private int[] elements;


    public ArrayList() {
        elements = new int[INITIAL_CAPACITY];
    }

    public void add(int i){

        if(size == elements.length){
            doubleCapacity();
        }
        elements[size++] = i;

    }

    public int get(int index){

        if(index<0 || index>=size){
              throw new ArrayIndexOutOfBoundsException(index);
        }

        return elements[index];

    }

    public int delete(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int returnVal = elements[index];
        System.arraycopy(elements,index+1,elements,index,(elements.length -(index+1)));
        elements[--size] = 0;

        return returnVal;
    }

    private void doubleCapacity(){

       int newLength = size*2;
       elements= Arrays.copyOf(elements,newLength);


    }

    public int size(){
        return  size;

    }
}
