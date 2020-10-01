package bag;

/**
 * An interface that describes the operations of a bag of objects
 * @param <T>
 */
public interface BagInterface <T> {
    /**
     * Gets the current number of entries in this bag
     * @return the integer number of entries currently in the bag
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag
     * @param newEntry The object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    public boolean add (T newEntry);

    /**
     * Removes one occurrence of a given entry from this bag
     * @param anEntry The entry to be removed
     * @return true if the removal is successful, or false if not
     */
    public boolean remove (T anEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return either the removed entry if the removal was successful, or null
     */
    public T remove();

    /**
     * Removes all entries from this bag
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in the bag
     * @param anEntry The entry to be counted
     * @return The number of times the anEntry appears in the bag
     */
    public int getFrequencyOf (T anEntry);

    /**
     * Tests whether this bag contains a given entry
     * @param anEntry The entry to find
     * @return  true if the bag contains anEntry, or false if not
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag
     *         Note: if the bag is empty, the array is empty
     */
    public T[] toArray();



}