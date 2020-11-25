package DLListProject;




import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>, Iterable<T> {
   private DNode<T> head;
   private DNode<T> tail;
   private int numberOfEntries;



    private DNode <T> getNodeAt (int position) {
        assert (position >= 0 && position < numberOfEntries);
        DNode <T> foundNode = head;
        for (int count = 0; count < position; count ++)
            foundNode = foundNode.getNext();
        return foundNode;
    }



    public void add(T newEntry) {
            add(numberOfEntries,newEntry);
    }

    public void add(int newPosition, T newEntry) {
        if (newPosition < 0 || newPosition > numberOfEntries)
            throw new IllegalArgumentException ("Position outside the chain");
        DNode <T> toInsert = new DNode (newEntry);

        if (isEmpty ()) {// only position 0 is valid
            head = tail = toInsert;
            numberOfEntries = 1;
        }
        else if (newPosition == numberOfEntries){
            addNodeAfter(tail,toInsert);
        }
        else {
            DNode <T> currNode = getNodeAt(newPosition);
            addNodeBefore(currNode, toInsert);
        }


    }

    public T remove(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= numberOfEntries)
            throw new IllegalArgumentException ("Removal out of range");
        DNode <T> toRemove = getNodeAt (givenPosition);
        T outData = toRemove.getData();
        removeNode(toRemove);
        return outData;

    }
    private void removeNode (DNode <T> toRemove) {
        DNode <T> before = toRemove.getPrev();
        DNode <T> after = toRemove.getNext();
        if (before == null) {
            head = after;
            if (head == null)
                tail = null;
            else
                head.setPrev(null);
        }
        else if (after == null) {
            tail = before;
            tail.setNext(null);
        }
        else {
            before.setNext(after);
            after.setPrev (before);
        }
        numberOfEntries --;
    }


    public boolean remove(T anEntry) {
        for (DNode <T> curr = head; curr != null;
             curr = curr.getNext()) {
            if (anEntry.equals (curr.getData())) { //removing
                removeNode(curr);
                return true;
            }
        }
        return false;


    }

    public void clear() {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }

    public T replace(int givenPosition, T newEntry) {
        //to do
        return null;
    }

    public T getEntry(int givenPosition) {
  if (givenPosition < 0 || givenPosition >= getLength())
        throw new IndexOutOfBoundsException();
        DNode<T> currNode = getNodeAt (givenPosition);
        return currNode.getData();
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        if (numberOfEntries == 0 ^ head == null) {
            throw new IllegalStateException("Corrupted chain of nodes");
        }
        return (numberOfEntries == 0);
    }

    public boolean contains(T anEntry) {
        for(DNode<T> currNode = head; currNode!=null; currNode=currNode.getNext()){
            if(anEntry.equals(currNode.getData()))
                return true;
        }
        return false;
    }


    public void reverse(){
       DNode<T> temp = null;
       DNode<T> curr = head;
       while (curr!=null){
           temp = curr.getPrev();
           curr.setPrev(curr.getNext());
           curr.setNext(temp);
            curr = curr.getPrev();
       }
       if(temp != null)
           head = temp.getPrev();
    }


    public void printList(){
        for(DNode<T> curr = head; curr!= null; curr = curr.getNext()){
            System.out.print(curr.getData()+" ");
        }


    }

    public Object[] toArray() {
        Object [] result = new Object [numberOfEntries];
        for(DNode<T> currNode = head; currNode!=null; currNode= currNode.getNext()){
            for(int i=0; i<result.length;i++){
                result[i] = currNode.getData();
            }
        }
        return result;
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) getIterator();
    }
    public ListIterator<T> getIterator(){
        return new DListIterator();
    }

    private void addNodeAfter (DNode <T> curr, DNode <T> after) {
        if (curr == tail) {
            tail.setNext(after);
            after.setPrev (tail);
            tail = after;
        }
        else {
            DNode <T> next = curr.getNext();
            curr.setNext (after);
            after.setNext (next);
            next.setPrev (after);
            after.setPrev (curr);
        }
        numberOfEntries ++;
    }

    private void addNodeBefore (DNode <T> currNode,
                                DNode <T> before) {
        if (currNode == head) {
            before.setNext(head);
            head.setPrev(before);
            head = before;
        }
        else {
            DNode <T> prev = currNode.getPrev();
            prev.setNext(before);
            before.setNext (currNode);
            currNode.setPrev(before);
            before.setPrev (prev);
        }
        numberOfEntries ++;
    }

    private void addFirstNode (DNode <T> toInsert) {
        toInsert.setNext (head);
        if (head == null) // the chain was empty
            tail = toInsert;
        else
            head.setPrev (toInsert);
        head = toInsert;
        numberOfEntries ++;
    }








    private enum Move{NEXT,PREV}
    private class DListIterator implements ListIterator<T> {
        private DNode<T> currNode;
        private int currIndex;
        private boolean isRemoveOrSetLegal = false;
        private Move lastMove = null;

        public DListIterator() {
            currNode = head;
            currIndex = 0;
        }

        public boolean hasNext() {
            return (currNode != null);
        }

        public boolean hasPrevious() {
            return (currNode == null && tail != null ||
                    currNode.getPrev() != null);
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T outData = currNode.getData();
            currNode = currNode.getNext();
            isRemoveOrSetLegal = true;
            lastMove = Move.NEXT;
            currIndex ++;
            return outData;
        }

        public T previous () {
            if (!hasPrevious())
                throw new NoSuchElementException();
            if (currNode == null)
                currNode = tail;
            else
                currNode = currNode.getPrev();
            isRemoveOrSetLegal = true;
            lastMove = Move.PREV;
            currIndex --;
            return currNode.getData();
        }
        public int nextIndex() {
            return currIndex;
        }

        public int previousIndex() {
            return currIndex - 1;
        }

        public void remove() {
            if (!isRemoveOrSetLegal)
                throw new IllegalStateException();
            if (lastMove == Move.NEXT) {
                if (!hasNext())
                    removeNode (tail);
                else
                    removeNode(currNode.getPrev());
                currIndex --;
            }
            else {
                DNode <T> temp = currNode.getNext();
                removeNode(currNode);
                currNode = temp;
            }
            isRemoveOrSetLegal = false;

        }

        public void add (T anEntry) {
            isRemoveOrSetLegal = false;
            DNode <T> toAdd = new DNode <> (anEntry);
            currIndex ++;
            if (isEmpty()) {
                tail = head = toAdd;
                numberOfEntries = 1;
            }
            else if (!hasNext())
                addNodeAfter (tail, toAdd);
            else if (!hasPrevious())
                addFirstNode (toAdd);
            else
                addNodeBefore(currNode, toAdd);
        }
        public void set (T anEntry) {
            if (!isRemoveOrSetLegal)
                throw new IllegalStateException();
            if (lastMove == Move.NEXT) {
                DNode <T> prevNode = (currNode == null ? tail : currNode.getPrev());
                prevNode.setData (anEntry);
            }
            else {
                currNode.setData (anEntry);
            }
            isRemoveOrSetLegal = false;

        }



    }


        public class DNode <T> {
        private T data;
        private DNode next;
        private DNode prev;

        public DNode (T data, DNode next, DNode prev) {
            this.data = data; this.next = next; this.prev = prev;
        }

        public DNode (T data) {
            this (data, null, null);
        }

        public T getData() {
            return data;
        }

        public void setData (T data) {
            this.data = data;
        }

        public DNode getNext() {
            return next;
        }

        public void setNext(DNode next) {
            this.next = next;
        }

        public DNode getPrev () {
            return prev;
        }

        public void setPrev(DNode prev) {
            this.prev = prev;
        }

    }

}
