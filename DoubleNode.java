public class DoubleNode <T>{
    private T item;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    DoubleNode(){
        this.item = null;
        this.next=null;
        this.prev=null;

    }

    DoubleNode(T anItem){
        this.item = anItem;
        this.next=null;
        this.prev=null;
    }

    DoubleNode( T anItem, DoubleNode<T> next, DoubleNode<T> prev){
        this.item=anItem;
        this.next=next;
        this.prev=prev;

    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    

 
    



}
