package GuessingGame;

public class LinkedBag<T> {

    private Node<T> head;
    private int size;

    public LinkedBag() {
        head = null;
        size = 0;
    }

    public int getCurrentSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 || head == null;
    }

    public boolean add(T entry) {
       Node <T> toAdd = new Node(entry);
        return true;
    }

    public LinkedBag<T> copy() {
        LinkedBag result = new LinkedBag();
        result.size = getCurrentSize();
        for (Node<T> current = head; current != null; current.getNext()) {
            result.add(current);
        }
        return result;
    }


    public int getFrequencyOf(T entry) {
        int answer = 0;
        for (Node<T> current = head; current != null; current.getNext()) {
            if (current.getData().equals(entry)) {
                answer++;
            }
        }
        return answer;
    }

    public T[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<T> current = head; current != null; current.getNext()) {
            array[i] = current.getData();
            i++;
        }
        return (T[]) array;
    }

    public boolean remove(T entry) {
        for (Node<T> current = head; current != null; current.getNext()) {
            if (current.getData().equals(entry)) {
                current.setData(head.getData());
                head = head.getNext();
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        LinkedBag<T> object = ((LinkedBag<T>) o).copy();
        if (object.size != getCurrentSize()) {
            return false;
        }
        for (Node<T> current = head; current != null; current.getNext()) {
            if (!object.remove(current.getData())) {
                return false;
            }
        }
        return true;
    }

    public LinkedBag<T> union(LinkedBag<T> o){
    LinkedBag<T> result = new LinkedBag<T>();
    for(Node<T> current = head; current!=null; current.getNext()){
        result.add(current.getData());
    }
    for(Node<T> current2 = o.head; current2!=null; current2.getNext()){
        result.add(current2.getData());
    }
        return result;
    }

    public LinkedBag<T> intersection(LinkedBag<T> o){
        LinkedBag<T> otherBag = o.copy();
        LinkedBag<T> resultBag = new LinkedBag<T>();
        for(Node<T> current = head; current!=null;current.getNext()){
            if(otherBag.remove(current.getData())){
                resultBag.add(current.getData());
                resultBag.size++;
            }
        }
return resultBag;
    }
    public void clearBag(){
        while(!isEmpty()){
            remove();
        }
    }


    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T entry = head.getData();
        head = head.getNext();
        size--;
        return entry;
    }


    public boolean contains(T entry) {
        for (Node current = head; current != null; current.getNext()) {
            if (current.getData().equals(entry)) {
                return true;
            }
        }
        return false;
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
    }
}
