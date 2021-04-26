import java.util.Iterator;

/**
 * Interface that represents a list.
 * Keep in mind this is DIFFERENT than the List interface from java.util
 *
 * @author 1331 TAs
 * @version 1.0
 * @param <T> - the generic type of the data to be stored in the list
 */
public interface List<T> extends Iterable<T> {
    /**
     * Inserts a Node with the passed-in data at the passed-in index in this list, if the index is valid.
     *
     * @param index - index at which the data is to be inserted
     * @param data - data to be inserted
     */
    void add(int index, T data);

    /**
     * Appends a Node with the passed-in data to the end of this list.
     *
     * @param data - data to be appended to this list
     */
    void add(T data);

    /**
     * Returns the data at the passed-in index in this list, if the index is valid.
     *
     * @param index - the index of the data to be retreived
     * @return the data at the passed-in index
     */
    T get(int index);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, otherwise false
     */
    boolean isEmpty();

    /**
     * Removes all of the elements from this list.
     */
    void clear();

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    Iterator<T> iterator();
}
