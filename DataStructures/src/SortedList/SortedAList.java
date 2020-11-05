package SortedList;

public class SortedAList < T extends Comparable < ? super T>>
        implements SortedListInterface <T>, Iterable<T> {
    private ListInterface<T> list;

    public SortedAList() {
        list = new AList<>();
    }

    public void addEntry(T newEntry) {
        int newPosition = getPosition(newEntry);
        if (newPosition < 0)
            newPosition = -newPosition - 1;
        list.add(newPosition, newEntry);

    }

    public boolean removeEntry(T anEntry) {
        int position = getPosition(anEntry);
        if (position >= 0) {
            list.remove(position);
            return true;
        }
        return false;
    }

    public int getPosition(T newEntry) {
        int position = 0;
        int compValue = 0;
        int length = list.getLength();
        while (position < length) {
            compValue = newEntry.compareTo(list.getEntry(position));
            if (compValue <= 0)
                break;
            position++;
        }
        if (position == length || compValue < 0)
            position = -1 - position;
        return position;
    }

    public T getEntry(int givenPosition) {
        return list.getEntry(givenPosition);
    }

    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    public T remove(int givenPosition) {
        return list.remove(givenPosition);
    }

    public void clear() {
        list.clear();
    }

    public int getLength() {
        return list.getLength();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object[] toArray() {
        return list.toArray();
    }


    public Iterator<T> iterator() {
        return new IteratorForSAList<>();
    }

    public Iterator<T> getIterator() {
        return iterator();
    }


    private class IteratorForSAList<T> implements Iterator<T> {
        private int cursor;

        public IteratorForSAList() {
            cursor = 0;
        }

        public boolean hasNext() {
            return (cursor < list.getLength());
        }

        public T next() {
            T[] array = (T[]) list.toArray();
            T result = array[cursor];
            cursor++;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}