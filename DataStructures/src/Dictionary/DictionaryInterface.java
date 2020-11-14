package Dictionary;

import java.util.Iterator;
/** An interface for a dictionary with distinct search keys

 */
public interface DictionaryInterface <K, V>{
    /** Adds a new entry to the dictionary, if the search key is already
     * in the dictionary, returns replaced value if value does not
     * already exist in dictionary. Returns null if value already exists in
     * the dictionary.
     * @param key: an object search key for the new entry
     * @param value: an object associated with the given search key
     * @return the replaced value or null if the value did exist
     * in the dictionary
     */
    public V add (K key, V value);

    /** Removes all entries from the dictionary with the associated key.
     * @param key an object search key for the entries to be removed
     * @return the removed value or null if the value did not exist
     * in the dictionary
     */
    public V remove (K key);

    /** Retrieves all the values associated with the given search key
     * @param key an object search key for the entry to be retrieved
     * @return the retrieved values or null if the value did not exist
     * in the dictionary
     */
    public V getValue (K key);


    /** Sees whether an entry with the given search key is in the
     *  dictionary
     * @param key an object search key of the desired entry
     * @return true or false
     */
    public boolean contains (K key);

    /** Creates an iterator that traverses all search keys in the
     * dictionary
     * @return an iterator that provides sequential access to all
     * search keys in the dictionary
     */
    public Iterator <K> getKeyIterator();




    /** Creates an iterator that traverses all values in the dictionary
     * @return an iterator that provides sequential access to all
     * values in the dictionary
     */
    public Iterator <V> getValueIterator();

    /**
     * Gets the size of this dictionary
     * @return the number of entries currently in the dictionary
     */
    public int getSize();



    /** Sees whether the dictionary is empty
     * @return true if the dictionary is empty; false otherwise.
     */
    public boolean isEmpty();

    /** Removes all entries from the dictionary
     */
    public void clear();

}
