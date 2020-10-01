//Michael Gawronski
package bag;

import java.util.Arrays;

public class ArrayBag <T> implements BagInterface <T> {
    private static final int DEFAULT_CAPACITY = 25;
    private T[] bagarray;
    private int numberOfEntries;

    /**
     * Creates an empty bag having a given initial capacity
     *
     * @param capacity The integer capacity desired
     */
    public ArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temparray = (T[]) new Object[capacity];
        bagarray = temparray;

        numberOfEntries = 0;
    }

    /**
     * Creates an empty bag having the default initial capacity
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public boolean add(T newEntry) {
        if (isFull())
            return false;
        if (newEntry == null)
            throw new IllegalArgumentException(" Illegal to add NULL ");
        bagarray[numberOfEntries++] = newEntry;
        return true;
    }


    private boolean isFull() {
        return (numberOfEntries == DEFAULT_CAPACITY);
    }

    public T[] toArray() {
        T[] result = Arrays.copyOf(bagarray, numberOfEntries);
        return result;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return (numberOfEntries == 0);
    }

    public void clear() {
        for (int idx = 0; idx < numberOfEntries; idx++)
            bagarray[idx] = null;
        numberOfEntries = 0;

    }

    public boolean remove(T anEntry) {
        for (int idx = 0; idx < numberOfEntries; idx++) {
            if (anEntry.equals(bagarray[idx])) {
                bagarray[idx] = bagarray[numberOfEntries - 1];
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    public T remove() {
        if (isEmpty())
            return null;
        T result = bagarray[numberOfEntries - 1];
        /*
        bagArray [numberOfEntries - 1] = null;
        numberOfEntries --;
                 */
        bagarray[--numberOfEntries] = null;

        return result;
    }

    public boolean contains(T anEntry) {
        for(int i=0; i< numberOfEntries; i++){
            if(anEntry.equals(bagarray[i])){
                return true;
            }
        }
        return false;
    }

    public int getFrequencyOf(T anEntry) {
        int frequency=0;
        for(int i=0; i< numberOfEntries; i++){
            if(anEntry.equals(bagarray[i])){
               frequency++;
            }
        }
        return frequency;
    }
}