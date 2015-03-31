package datastructures;

import java.util.NoSuchElementException;

/**
 * Created by ananthmajumdar on 3/31/15.
 */
public class DoublyLinkedList {

    private Entry first=null;
    private Entry last = null;
    private int size=0;

    public Entry getFirst(){
        return first;
    }

    public Entry getLast(){
        return last;
    }

    public int getSize(){
        return size;
    }

    public void add(int i){
        //add at the end of the list
        addLast(i);
    }

    public void addFirst(int i){
        if(first==null){
            Entry e= new Entry();
            e.setData(i);
            e.setPrev(null);
            e.setNext(null);
            first = last = e;
            size++;
        }
        else{
            Entry e= new Entry();
            e.setData(i);
            e.setPrev(null);
            first.setPrev(e);
            e.setNext(first);
            first = e;
            size++;
        }

    }

    public void addLast(int i){
        if(last==null){
            Entry e= new Entry();
            e.setData(i);
            e.setPrev(null);
            e.setNext(null);
            first = last = e;
            size++;
        }
         else{
            Entry e= new Entry();
            e.setData(i);
            e.setPrev(last);
            last.setNext(e);
            e.setNext(null);
            last = e;
            size++;
        }

    }

    public boolean remove(int i){

        Entry e= first;

        while(e!=null){

            if(e.getData()==i){
              if(e.getPrev()!=null)  {
                    e.getPrev().setNext(e.getNext());
                }else{
                  first = e.getNext();
              }
                size--;
                return true;
            }else{
                e = e.getNext();
            }

        }

        return false;

    }

    public void removeFirst(){
        if(size==0){
            throw new NoSuchElementException();
        }else{
            if(first.getNext()!=null){
                first.getNext().setPrev(null);
                size--;
            }else {
                //no other elements first=last
                last=null;
                size--;
            }

            first = first.getNext();
        }
    }

    public void removeLast(){
        if(size==0){
            throw new NoSuchElementException();
        }else{
            if(last.getPrev()!=null){
                last.getPrev().setNext(null);
                size--;
            }else {
                //no other elements first=last
                size--;
                first=null;
            }

            last = last.getPrev();
        }
    }


    class Entry{
        private int data;
        private Entry next;
        private Entry prev;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public Entry getPrev() {
            return prev;
        }

        public void setPrev(Entry prev) {
            this.prev = prev;
        }
    }

}





