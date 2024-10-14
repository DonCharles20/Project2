/******************************************
 * @Author      :   Ali Azhari
 * @Date        :   Created On :  Oct 01 2024
 * @File        :   Node.java
 * @Description :   TODO
 *******************************************/
public class Node<T> {

    private T item;
    private Node<T> next;

    

    /**
     * Default Constructor
     */
    public Node() {

    }

    /**
     * Overload Constructor with one parameter (item)
     * @param item
     */
    public Node(T item) {
        this(item, null);
    }

    /**
     * Overload Constructor with two parameters (item and next node)
     * @param item
     * @param next
     */
    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    // Getters and Setters
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}