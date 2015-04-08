package datastructures;

import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 4/1/15.
 */
public class HashTable {

    public Entry[] getTable() {
        return table;
    }

    public void setTable(Entry[] table) {
        this.table = table;
    }

    private Entry[] table;

    public int getCount() {
        return count;
    }

    private int count=0;
    private int size;


    public HashTable(){
        size = 10;//initial size
        table = new Entry[size];

    }

    public void put(String key, int value){

        int bucket = (key.hashCode()& 0X7FFFFFFF)%size;

        Entry e = table[bucket];



        while(e!=null){

            if(key.equals(e.getKey())){
                //replace existing val
                e.setData(value);
                return;
            }else{
                e =e.getNext();
            }


        }

        e = table[bucket];
        Entry newEntry = new Entry();
        newEntry.setData(value);
        newEntry.setKey(key);
        newEntry.setNext(e);
        table[bucket] = newEntry;
        count++;

    }

    public int get(String key){
        int bucket = (key.hashCode()& 0X7FFFFFFF)%size;
        int returnVal =-1;
        Entry e = table[bucket];

        while(e!=null){

            if(key.equals(e.getKey())){
                //replace existing val
             returnVal = e.getData();
                break;
            }else{
                e =e.getNext();
            }


        }

        if(e==null){
            throw new NoSuchElementException();
        }

               return returnVal;
    }

    public int delete(String key){
        int bucket = (key.hashCode()& 0X7FFFFFFF)%size;
        int returnVal =-1;
        Entry e = table[bucket];
        Entry parent = null;

        while(e!=null){

            if(key.equals(e.getKey())){
                //replace existing val
                returnVal = e.getData();
                if(parent ==null){
                    table[bucket]=e.getNext();
                }else{
                    parent.setNext(e.getNext());
                }
                 count--;
                break;
            }else{
                parent = e;
                e =e.getNext();
            }


        }
        if(e==null){
            throw new NoSuchElementException();
        }


        return returnVal;
    }

    class Entry {
        private int data;
        private String key;
        private Entry next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }
}
