//Michael Gawronski
package ListProject;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class AList<T> implements ListInterface<T> {
    private T[] list;
    private int numberOfEntries;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;

    public AList(int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        else
            checkCapacity(capacity);
        this.capacity = capacity;
        T[] temp = (T[]) new Object[capacity];
        list = temp;
        numberOfEntries = 0;
    }

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(T anEntry) {
        if (anEntry == null)
            throw new IllegalArgumentException();
        list[numberOfEntries] = anEntry;
        numberOfEntries++;
        ensureCapacity();
    }
    public void add (int newPosition, T newEntry){
        if (newPosition < 0 || newPosition > numberOfEntries)
            throw new IndexOutOfBoundsException();
        makeRoom (newPosition);
        list[newPosition] = newEntry;
        numberOfEntries ++;
        ensureCapacity();
    }
    private void removeGap(int givenPosition) {
        assert (givenPosition >= 0 && givenPosition < numberOfEntries);
        for (int index = givenPosition; index < numberOfEntries; index ++){
            list[index] = list[index+1];
        }
    }
    public T remove (int givenPosition){
        T theEntry;
        if (givenPosition < 0 || givenPosition >= numberOfEntries)
            throw new IndexOutOfBoundsException(
                    "Illegal Position given to remove operation");
        theEntry = list[givenPosition];
        removeGap(givenPosition);
        numberOfEntries --;
        return theEntry;
    }


    public boolean remove(T anEntry) {
       for (int i = 0; i < list.length ; i++) {
            if(list[i].equals(anEntry)){
                removeGap(i);
                numberOfEntries--;
                return true;
            }
        }
       return false;
    }


    public void clear() {
    for(int i = list.length; i > 0; i--){
        remove(i);
    }

    }


    public T replace(int givenPosition, T newEntry) {
        if (givenPosition < 0 || givenPosition >= numberOfEntries)
            throw new IndexOutOfBoundsException(
                    "Illegal Position given to remove operation");

        remove(givenPosition);
        add(givenPosition, newEntry);
        return newEntry;
    }


    public T getEntry(int givenPosition) {
        T theEntry;
        theEntry = list[givenPosition];
        return theEntry;
    }


    public int getLength() {
        return numberOfEntries;
    }


    public boolean isEmpty() {
        return (numberOfEntries==0);
    }


    public boolean contains(T anEntry) {
        for(T entry : list){
            if(entry.equals(anEntry));
            return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[numberOfEntries];
        for (int idx = 0; idx < numberOfEntries; idx++)
            result[idx] = list[idx];
        return result;
    }
    private void checkCapacity (int capacity) {
        if (capacity >= MAX_CAPACITY)
            throw new InvalidParameterException(
                    "Capacity too big");
    }
    private void ensureCapacity(){
        if (isFull()) {
            capacity *= 2;
            checkCapacity (capacity); // too big ?
            list = Arrays.copyOf(list, capacity);
        }
    }
    private void makeRoom (int newPosition){
        assert (newPosition >= 0 && newPosition <= numberOfEntries);
        for (int idx = numberOfEntries; idx > newPosition; idx --)
            list[idx] = list[idx-1];
    }

    private boolean isFull() {
        return (numberOfEntries == capacity);
    }

    public void reverse(){
     AList<T> newList = new AList<>();
     for(int i = list.length; i > 0;i--) {
         newList.add(remove(i));
     }
     list = (T[]) newList.toArray();

    }




}