import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Andrew Friedman.
 * @version 1.00.
 * @param <T> [description].
 */
public class LinkedList<T> implements List<T> {
    private Node head;
    private int size;

    /**
     * [LinkedList description].
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * [add description].
     * @param index [description].
     * @param data  [description].
     */
    public void add(int index, T data) {
        try {
            Node previous = null;
            Node current = head;
            if (index == 0) {
                if (current == null) {
                    head = new Node<T>(data);
                } else {
                    head = new Node<T>(data, current);
                }
                return; //break
            }
            try {
                while (index > 0) {
                    previous = current;
                    current = current.getNext();
                    index--;
                }
                previous.setNext(new Node<T>(data, current));
                size++;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }

    /**
     * [add description].
     * @param data [description].
     */
    public void add(T data) {
        try {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(data, null));
            size++;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }

    /**
     * [get description].
     * @param  index [description].
     * @return       [description].
     */
    public T get(int index) {
        try {
            Node current = head;
            while (index > 0) {
                current = current.getNext();
                index--;
            }
            @SuppressWarnings("unchecked") T temp = (T) current.getData();
            return temp;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("");
        }
        return null;
    }

    /**
     * [isEmpty description].
     * @return [description].
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * [clear description].
     */
    public void clear() {
        while (size != 0) {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current = null;
            size--;
        }
    }

    /**
     * [iterator description].
     * @return [description].
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> nextNode;

        ListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            try {
                T nextData = nextNode.getData();
                nextNode = nextNode.getNext();
                return nextData;
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                System.out.println("");
            }
            return null;
        }
    }
}
