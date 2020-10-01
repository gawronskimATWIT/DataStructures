package stackpackage;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayStack <T>{
    private T[] stackArray;
    private int stackLength;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 50;

public ArrayStack(int capacity){
    @SuppressWarnings("unchecked")
    T[] tempArray = (T[]) new Object[capacity];
stackArray = tempArray;
stackLength=0;
}
public ArrayStack(){
    stackArray= (T[]) new Object[DEFAULT_CAPACITY];

}

private boolean isFull(){
    return (stackLength==capacity);
}
public boolean isEmpty(){
    return (stackLength==0);
}

    private void ensureCapacity() {
        capacity *= 2;
        Object[] temp = new Object [capacity];
        for (int i = 0; i < stackLength; i++)
            temp [i] = stackArray[i];
            stackArray = (T[]) temp;
    }

    public void push ( T entry) {
        stackArray[stackLength] = entry;
        stackLength++;
        if (isFull())
            ensureCapacity();
    }

    public T pop () {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
            T result = stackArray[stackLength-1];
        stackArray[stackLength-1] = null;
        stackLength--;
        return result;
    }
    public T peek(){
    if(isEmpty()){
        throw  new EmptyStackException();
    }
    return stackArray[stackLength-1];
    }





}
