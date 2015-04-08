package datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ananthmajumdar on 4/8/15.
 */
public class HashTableTest {

    @Test
    public void testPut() throws Exception {
            HashTable hashTable = new HashTable();
        hashTable.put("one",1);
        hashTable.put("two",2);
        hashTable.put("three",3);
        //System.out.println(hashTable.getCount());
        assertTrue(hashTable.getCount()==3);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGet() throws Exception {
        HashTable hashTable = new HashTable();
        hashTable.put("one",1);
        hashTable.put("two",2);
        hashTable.put("three",3);
        assertTrue(hashTable.get("three") == 3);
        assertTrue(hashTable.get("two")==2);
        hashTable.get("four");

    }

    @Test(expected = NoSuchElementException.class)
    public void testDelete() throws Exception {
        HashTable hashTable = new HashTable();
        hashTable.put("one",1);
        hashTable.put("two",2);
        hashTable.put("three", 3);
        assertTrue(hashTable.delete("three") == 3);
        assertTrue(hashTable.delete("two")==2);
        hashTable.get("four");

    }
    @Test(expected = NullPointerException.class)
    public void testNullKey() throws Exception {
        HashTable hashTable = new HashTable();
        hashTable.put(null,1);
    }
}