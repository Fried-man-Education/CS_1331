/**
 * @author Andrew Friedman.
 * @version 1.00.
 * @param <T> [description].
 */
public class Node<T> {
    private T data;
    private Node next;
    /**
     * [Node description].
     * @param data [description].
     * @param next [description].
     */
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    /**
     * [Node description].
     * @param data [description].
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    /**
     * [getData description].
     * @return [description].
     */
    public T getData() {
        return data;
    }
    /**
     * [setData description].
     * @param data [description].
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * [getNext description].
     * @return [description].
     */
    public Node getNext() {
        return next;
    }
    /**
     * [setNext description].
     * @param next [description].
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
