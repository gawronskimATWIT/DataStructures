//Michael Gawronski
package bag;

import javax.print.DocFlavor;
import java.util.Arrays;

public class ResizableArrayBag <T> implements BagInterface <T> {
    private T[] bagArray;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 20;
    private int capacity;

    public ResizableArrayBag (int capacity) {
        Object [] temp = new Object [capacity];
        bagArray = (T [] ) temp;
        numberOfEntries = 0;
        this.capacity = capacity;
    }

    public ResizableArrayBag () {
        this (DEFAULT_CAPACITY);
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    public boolean add (T newEntry) {
        if (newEntry == null)
            throw new IllegalArgumentException(" Illegal to add NULL ");
        if (isFull () )
            doubleCapacity();
        bagArray[numberOfEntries++] = newEntry;
        return true;
    }

    public boolean remove (T anEntry) {
        if (isEmpty())
            return false;
        for (int idx = 0; idx <= numberOfEntries; idx ++)  {
            if (bagArray[idx].equals(anEntry)) {
                bagArray [idx] = bagArray[numberOfEntries - 1];
                bagArray [-- numberOfEntries ] = null;
                return true;
            }
        }
        return false;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T result = bagArray [numberOfEntries - 1];
        bagArray [-- numberOfEntries ] = null;
        return result;
    }

    public void clear() {
        while (!isEmpty ())
            remove();
    }

    public int getFrequencyOf (T anEntry) {
        int count = 0;
        for (int idx = 0; idx < numberOfEntries; idx ++ ) {
            if (bagArray[idx].equals (anEntry))
                count ++;
        }
        return count;

    }

    public boolean contains (T anEntry) {
        for (int idx = 0; idx < numberOfEntries; idx ++ ) {
            if (bagArray[idx].equals (anEntry))
                return true;
        }
        return false;
    }

    public T [] toArray (){
        Object [] result = new Object [numberOfEntries];
        for (int idx = 0; idx < numberOfEntries; idx ++)
            result [idx] = bagArray[idx];
        return (T[]) result;
    }

    public T[] toArray (T[] a) {
        T[] result = Arrays.copyOf (a, numberOfEntries);
        for (int idx = 0; idx < numberOfEntries; idx ++)
            result[idx] = bagArray [idx];
        return result;
    }

    private boolean isFull () {
        return (numberOfEntries == capacity);
    }

    public ResizableArrayBag<T> copy(){
 ResizableArrayBag answer = new ResizableArrayBag(this.capacity);
    answer.bagArray = toArray(this.bagArray);
    answer.numberOfEntries=getCurrentSize();
    return answer;
}
    @Override
    public boolean equals (Object other) {
        ResizableArrayBag<T> o = ((ResizableArrayBag<T>) other).copy();
        boolean sameSize = getCurrentSize() == o.getCurrentSize();
        for (int i = 0; i < o.numberOfEntries; i++) {
            if (!o.remove(bagArray[i])) {
                return false;
            }
       }
        if (!sameSize) {
            return false;
        }
        return true;
    }


        public ResizableArrayBag <T> union (ResizableArrayBag<T> other){
            ResizableArrayBag<T> bag = new ResizableArrayBag<>();
           for(int i=0; i < numberOfEntries; i++) {
               bag.add(bagArray[i]);
           }
            T[] arrayO = other.toArray();
            for(int ii=0; ii<arrayO.length; ii++){
                bag.add(arrayO[ii]);
            }
            return bag;
        }



    private void doubleCapacity() {
        capacity *= 2;
        Object[] temp = new Object [capacity];
        for (int idx = 0; idx < numberOfEntries; idx ++)
            temp [idx] = bagArray[idx];
        bagArray = (T[]) temp;
    }


}