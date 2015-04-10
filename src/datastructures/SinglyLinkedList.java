package datastructures;

/**
 * Created by ananthmajumdar on 3/30/15.
 */
public class SinglyLinkedList {


    public Entry getHead() {
        return head;
    }

    private Entry head;
    private int size=0;



    public void add(int i){

       Entry e = head;

        if(e==null){
            Entry temp   = new Entry();
            temp.setData(i);
            temp.setNext(null);
            head = temp;
            size++;
        } else{

            while(e.getNext()!=null){
                e = e.getNext();
            }
            Entry temp   = new Entry();
            temp.setData(i);
            temp.setNext(null);
            e.setNext(temp);
            size++;

        }
    }


    public int getSize(){
        return size;
    }

    public void display(){
        Entry e = head;

        while(e!=null){
            System.out.println(e.getData());
            e=e.getNext();
        }
    }

    public int remove(int i){

        int returnVal =0;
        Entry e = head;
        Entry prev = null;
        boolean found = false;

        while(e!=null&&!found){
            if(e.getData()==i){
                found=true;
                returnVal=1;
                if(prev==null){
                   head = e.getNext();
                    size--;
                }else{
                    prev.setNext(e.getNext());
                    size--;
                }

            }else{
                prev =e;
                e = e.getNext();

            }
        }

     return returnVal;
    }

    class Entry{


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

        private int data;
        private Entry next;
    }

    public SinglyLinkedList() {
        head = null;
    }



    public SinglyLinkedList reverse(){
        SinglyLinkedList returnVal = new SinglyLinkedList();
        //TODO reverse the list iteratively and recursive

        Entry currHead = this.getHead();
        Entry temp = null;
        Entry prev = null;

        while(currHead!=null){

            temp = new Entry();
            temp.setData(currHead.getData());
            returnVal.head = temp;
            returnVal.head.setNext(prev);
            prev = temp;
            currHead = currHead.getNext();


        }

        return returnVal;




    }
}
