package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/6/15.
 */
public class BinarySearchTreeTest {

    @Test
    public void testInsert() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
        assertTrue(bst.getRoot().getData() == 6);
    }

    @Test
    public void testDelete() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
        bst.delete(6);
        assertTrue(bst.getRoot().getData() == 7);
    }

    @Test
    public void testSearch() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
       BinarySearchTree.TreeNode treeNode= bst.search(5);
        assertTrue(treeNode.getData() == 5);
        assertTrue(bst.search(3)==null);
    }



    @Test
    public void testFindMinimum() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(2);
        bst.insert(9);
        assertTrue(bst.findMinimum().getData() == 2);
    }
}