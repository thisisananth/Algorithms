package datastructures;

import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class PriorityQueue {

    //insert
    //find-minimum
    //delete-minimum

    //sorted array
    //unsorted array
    //balanced bst


    private BinarySearchTree bst;
    private BinarySearchTree.TreeNode minimum;


    public PriorityQueue(){
        bst = new BinarySearchTree();
    }

    public void insert(int i){
            bst.insert(i);
        minimum = bst.findMinimum();
    }

    public int findMinimum(){

        if(minimum==null){
            throw new NoSuchElementException();
        }
        return minimum.getData();
    }

    public void deleteMinimum(){
        if(minimum==null){
            return;
        }else{
            bst.delete(minimum.getData());
            minimum = bst.findMinimum();
        }
    }



}
