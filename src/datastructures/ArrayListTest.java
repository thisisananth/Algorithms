package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayList(){
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<12;i++){
            arrayList.add(i);
        }
        assertTrue(arrayList.get(1)==1);
       assertTrue(arrayList.size()==12);
        arrayList.get(-1);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAdd() throws Exception {
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<12;i++){
            arrayList.add(i);
        }
        assertTrue(arrayList.get(1)==1);
        arrayList.get(12);


    }

    @Test
    public void testGet() throws Exception {
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<12;i++){
            arrayList.add(i);
        }
        assertTrue(arrayList.get(10)==10);
        assertFalse(arrayList.get(9)==10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testDelete() throws Exception {
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<12;i++){
            arrayList.add(i);
        }
        assertTrue(arrayList.delete(10)==10);
        assertTrue(arrayList.get(10) == 11);
        assertTrue(arrayList.size()==11);
        arrayList.delete(11);

    }
}