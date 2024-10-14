/******************************************
 * @Author      : Ali Azhari
 * @ate         : Created On : Oct 01 2024
 * @File        : DoubleLinkedList.java
 * @Description : TODO
 *******************************************/

public class LinkedList<T> implements MyListInterface<T> {

  private Node<T> head;
  private int itemCount;

  public LinkedList() {

    head = null;
    itemCount = 0;

  }

  /** *************************************** */
  @Override
  public boolean isEmpty() {
    return (itemCount == 0);

  }

  /** *************************************** */
  @Override
  public int getLength() {
    
    Node<T> walker = head;
    int length = 0;

    while (walker != null) {
      walker = walker.getNext();
      length++;
    }
    return length;
  }

  /** *************************************** */
  @Override
  public boolean insert(int position, T item) {

    if (position > (itemCount + 1) || (position < 1))
      return false;

    Node<T> newNode = new Node<>(item);
    if (position == 1) {
      newNode.setNext(head);
      head = newNode;
    }

    Node<T> previous = getNodeAt(position - 1);

    newNode.setNext(previous.getNext());
    previous.setNext(newNode);
    return true;

  }

  /** *************************************** */
  @Override
  public T remove(int position) {
    if (head == null)
      return null;

      // Be careful here. This might not be complete.
      // Take in cosideration of a list that has only one node
    Node<T> previous = getNodeAt(position - 1);
    Node<T> temp = previous.getNext();
    previous.setNext(temp.getNext());

    return temp.getItem();

  }

    /** *************************************** */
  public void clear() {
    head = null;
    itemCount = 0;
  }

  /** *************************************** */
  @Override
  public T getEntry(int position)  throws IndexOutOfBoundsException {

    if (head == null)
      throw new IndexOutOfBoundsException();

    return getNodeAt(position).getItem();
  }
/** *************************************** */
@Override
  public T replace(int position, T entry) throws IndexOutOfBoundsException {

   if (head == null)
    throw new IndexOutOfBoundsException();
    
     Node<T> node = getNodeAt(position);
     T item = node.getItem();
     node.setItem(entry);
    return item;

  }

  /** *************************************** */
  public int getIndexOf(T entry) {

    if(head == null)
    return -1;

    Node<T> walker = head;

    int position = 0;
    while (walker != null) {
      if (walker.getItem().equals(entry)) {
        return position;
      }
      position++;
    }
    return -1;
  }

  /** *************************************** */
  @Override
  public Object[] toArray() {

    if (itemCount == 0)
      return null;

    Object[] array = new Object[itemCount];
    Node<T> walker = head;

    for (int i = 0; i < itemCount; i++) {
      array[i] = walker.getItem();
      walker = walker.getNext();
    }

    return array;
  }

  /** *************************************** */

  private Node<T> getNodeAt(int position) {
    if (head == null)
      return null;

    Node<T> walker = head;

    for (int i = 0; i < position; i++)
      walker = walker.getNext();

    return walker;

  }






}