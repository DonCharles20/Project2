import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class DoubleLinkedList<T> implements MyListInterface {
    private DoubleNode<T> head;
    private int itemCount;
    private Finger<T>[] finger;

    @SuppressWarnings("unchecked")
    DoubleLinkedList() {
        this.head = null;
        this.itemCount = 0;
        this.finger = (Finger<T>[]) new Finger[4];
    }

    public boolean isEmpty() {
        if (itemCount <= 0) {
            return true;
        }
        return false; 

    }

    public int getLength() {
        return itemCount;
    }

    public boolean insert(int position, Object entry) {
        @SuppressWarnings("unchecked")
        DoubleNode<T> newNode = new DoubleNode<T>((T) entry);
        if (position < 0 || position > itemCount+1) {
            return false;
        }

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
            itemCount++;
            updateFinger(position, newNode);
            return true;
        }

        DoubleNode<T> temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.setNext(newNode);
        updateFinger(position, temp);
        itemCount++;

        if (head != null) {
            head.setPrev(newNode);
        }

        return true;

    }

    public T remove(int position) {
        if (position < 0 || position > itemCount) {
            return null;
        }
        if (position == 0) {
            head = head.getNext();
            itemCount--;
            updateFinger(position, head);
            if (head != null) {
                head.setPrev(null);

            }
        } else {
            DoubleNode<T> temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            DoubleNode<T> nodeToRemove = temp.getNext();
            temp.setNext(nodeToRemove.getNext());

            if (nodeToRemove.getNext() != null) {
                nodeToRemove.getNext().setPrev(temp);
            }
        }
        itemCount--;
        updateFinger(position, head);
        return null;
    }

    public void clear() {
        head = null;
        itemCount = 0;
    }

    public T getEntry(int position) {
        if (position < 0 || position > itemCount || isEmpty()) {
            return null;
        }
        return getNodeAt(position).getItem();
    }

    @SuppressWarnings("unchecked")
    public T replace(int position, Object entry) {
        if (position < 0 || position > itemCount || isEmpty()) {
            return null;
        }
        DoubleNode<T> temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }
        temp.setItem((T) entry);
        return (T) entry;
    }

    public int getIndexOf(T key) {
        DoubleNode<T> temp = head;
        for (int i = 0; i < itemCount; i++) {
            if (temp.getItem().equals(key)) {
                return i;
            }
            temp = temp.getNext();
        }

        return -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[itemCount];
        DoubleNode<T> temp = head;
        for (int i = 0; i < itemCount; i++) {
            arr[i] = temp.getItem();
            temp = temp.getNext();
        }

        return arr;
    }

    private DoubleNode<T> getNodeAt(int position) {
        if (position < 0 || position > itemCount || isEmpty()) {
            return null;
        }

        DoubleNode<T> temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }

        return temp;
    }


    private void updateFinger(int position, DoubleNode<T> curr) {
        // Ensure we have at least 4 positions to place the fingers
    if (itemCount == 0 || finger.length == 0) {
        return;
    }
    
    // Place the first finger at the head (position 0)
    finger[0] = new Finger<>(0, head);

    // Distribute the remaining fingers evenly based on the list size
    int step = itemCount / (finger.length - 1); // Divide the list into (finger.length - 1) intervals
    
    // Update each finger
    for (int i = 1; i < finger.length; i++) {
        int fingerPosition = step * i; // Find the position for this finger
        if (fingerPosition >= itemCount) {
            fingerPosition = itemCount - 1; // Prevent out of bounds
        }
        DoubleNode<T> nodeAtFinger = getNodeAt(fingerPosition); // Get the node at the finger's position
        finger[i] = new Finger<>(fingerPosition, nodeAtFinger); // Set the finger
    }

    }
    
    
    private Finger<T> getClosest(int idx) {
        if (idx < 0 || idx > itemCount) {
            return null;
        }
        if (idx == 0) {
            return new Finger<>(0, head);
        }
        for (int i = 0; i < finger.length; i++) {
            if (finger[i] != null) {
                if (Math.abs(finger[i].getIdx() - idx) <= 1) {
                    return finger[i];
                }
            }
        }
        return new Finger<>(idx, getNodeAt(idx));
        
    }
 
    public String toString() {
        if (isEmpty()) {
            return "Empty List";
        }
        DoubleNode<T> temp = head;
        String str = "";
        for (int i = 0; i < itemCount; i++) {
            str += temp.getItem().toString() + " ";
            temp = temp.getNext();
        }
        return str;
    }

    public void sort(Comparator<T> comparator) {
        if (isEmpty()) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            DoubleNode<T> current = head;
            
            while (current != null && current.getNext() != null) {
                if (comparator.compare(current.getItem(), current.getNext().getItem()) > 0) {
                    // Swap the items
                    T temp = current.getItem();
                    current.setItem(current.getNext().getItem());
                    current.getNext().setItem(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
    public int getItemCount() {
        return itemCount;
    }


}
