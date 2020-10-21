package List;



public class LList <T> implements ListInterface <T> {
    private Node <T> firstNode;
    private int numberOfEntries;

    public LList () {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Add new entry at the end of the list
     * @param newEntry
     */
    public void add (T newEntry) {
        numberOfEntries ++;
        Node<T> lastNode = getLastNode();
        Node <T> toAdd = new Node <> (newEntry);
        if (lastNode == null) // empty chain
            firstNode = toAdd;
        else
            lastNode.setNext (toAdd);
    }

    public Node <T> getLastNode() {

        Node <T> lastNode = firstNode;
        if (lastNode != null) {
            Node <T> nextNode = firstNode.getNext();
            while (nextNode != null) {
                lastNode = nextNode;
                nextNode = nextNode.getNext();
            }
        }
        return lastNode;
    }


    /**
     * Adds new entry at specified position; shifts the entries to
     * reserve space for newEntry
     * @param newPosition
     * @param newEntry
     * @throws IndexOutOfBoundsException if either givenPosition < 0
     * or givenPosition > getLength()
     */
    public void add (int newPosition, T newEntry) {
        Node <T> toInsert = new Node <> (newEntry);
        numberOfEntries ++;
        if (newPosition == 0) {
            toInsert.setNext(firstNode);
            firstNode = toInsert;
            return;
        }
        Node <T> before = getNodeAt (newPosition - 1);
        assert (before != null);
        Node <T> after = before.getNext();
        before.setNext (toInsert);
        toInsert.setNext(after);
    }

    private Node <T> getNodeAt (int position) {
        assert (position >= 0 && position < numberOfEntries);
        Node <T> currNode = firstNode;
        for (int i = 0; i < position; i ++)
            currNode = currNode.getNext();
        return currNode;
    }

    /**
     * Removes an entry at given position
     * @param givenPosition
     * @return the removed entry
     * @throws IndexOutOfBoundsException if either givenPosition < 0
     * or givenPosition >= getLength()
     */
    public T remove (int givenPosition) {
        if (givenPosition < 0 || givenPosition >= getLength())
            throw new IndexOutOfBoundsException();
        T dataItem;
        Node <T> nextNode;
        numberOfEntries --;

        if (givenPosition == 0) {
            dataItem = firstNode.getData();
            firstNode = firstNode.getNext();
        }
        else {
            Node <T> currNode = getNodeAt(givenPosition -1);
            nextNode = currNode.getNext();
            assert (nextNode != null);
            dataItem = nextNode.getData();
            currNode.setNext(nextNode.getNext());
        }
        return dataItem;

    }

    /**
     * Removes the specified entry from the list
     * @param anEntry
     * @return true if the entry was in the list; false otrherwise
     */
    public boolean remove ( T anEntry) {
        Node <T> currNode = firstNode;
        Node <T> prevNode = null;
        while (currNode != null) {
            if (anEntry.equals(currNode.getData())) {
                numberOfEntries --;
                if (prevNode == null) {// match at the beginning
                    currNode = currNode.getNext();
                    firstNode = currNode;
                }
                else  // in the middle or at the end
                    prevNode.setNext (currNode.getNext()); // unlink currNode

                return true;
            }
            else {
                prevNode = currNode;
                currNode = currNode.getNext();
            }
        }
        return false;
    }

    /**
     /* Removes all entries from the list
     */
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Replaces an entry at given position with a new one
     * @param givenPosition
     * @param newEntry
     * @return the replaced entry
     * @throws IndexOutOfBoundsException if either givenPosition < 0
     * or givenPosition >= getLength()
     */
    public T replace (int givenPosition, T newEntry) {
        if (givenPosition < 0 || givenPosition >= getLength())
            throw new IndexOutOfBoundsException();

        return null; // to implement; null should be changed to meaningful value
    }

    /**
     * Retrieves an entry at given position
     * @param givenPosition
     * @return the entry at givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 0
     * or givenPosition >= getLength()
     */
    public T getEntry (int givenPosition) {
        if (givenPosition < 0 || givenPosition >= getLength())
            throw new IndexOutOfBoundsException();
        Node <T> currNode = getNodeAt (givenPosition);
        return currNode.getData();
    }

    /**
     /* Gets the length of this list
     /* @return the integer number of entrieas currently in the list
     */
    public int getLength() {
        return numberOfEntries;
    }
    /**
     /* Sees whether this list is empty
     /* return true if the list is empty, false if not
     */
    public boolean isEmpty() {
        if (numberOfEntries == 0 ^ firstNode == null) {
            throw new IllegalStateException("Corrupted chain of nodes");
        }
        return (numberOfEntries == 0);
    }


    /**
     /* Sees whether the list contains the given entry
     /* @param anEntry the object: desired entry
     /* @return true if the list contains anEntry; false if not.
     */
    public boolean contains (T anEntry) {
        for(Node<T> currNode = firstNode; currNode!=null; currNode=currNode.getNext()){
            if(anEntry.equals(currNode.getData()))
            return true;
        }
        return false;
    }



    /** Retrieves all entries that are in this list in the order they
     *occur in the list.
     * @ return a newly allocated array of all the entries in the list
     * If the list is empty, the returned array is empty
     */
    public Object[] toArray() {
        Object [] result = new Object [numberOfEntries];
       for(Node<T> currNode = firstNode; currNode!=null; currNode= currNode.getNext()){
           for(int i=0; i<result.length;i++){
               result[i] = currNode.getData();
           }
       }
        return result;
    }


    public void reverse(){
        Node<T> previousNode = null;
        Node<T> next = null;
       Node<T> currNode = firstNode;
       while (currNode!=null){
           next = currNode.getNext();
           currNode.setNext(previousNode);
           previousNode = currNode;
           currNode = currNode.getNext();
       }
       firstNode = previousNode;
    }


private class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T newData) {
        data = newData;
    }

    public void setNext(Node<T> data) {
        next=data;
    }
}




}
