public class DoubleLinkedListcopy<T> implements MyListInterface{
    private DoubleNode<T> head;
    private int itemCount;

    DoubleLinkedListcopy(){
        this.head=null;
        this.itemCount=0;
    }

    public boolean isEmpty(){
        if (itemCount<=0) {
            return true;
        }
        return false;

    }

    public int getLength(){
        return itemCount;
    }

    public boolean insert(int position, Object entry){
        DoubleNode<T> newNode = new DoubleNode<T>((T) entry);
        if(position<0 || position>itemCount||isEmpty()){
            return false;
        }
        if (position==0) {
            newNode.setNext(head);
            head = newNode;
            itemCount++;
            return true;
        }

        DoubleNode <T> temp = head;
        for(int i=0;i<position-1;i++){
            temp=temp.getNext();
        }
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);
        itemCount++;

        if (head != null) {
            head.setPrev(newNode);
        }
        
        return true;

    }

    public T remove(int position){
        if(position<0 || position>itemCount||isEmpty()){
            return null;
        }
        if (position==0) {
            head = head.getNext();
            itemCount--;
            if (head != null) {
                head.setPrev(null);
                
            }
        }else{
            DoubleNode<T> temp = head;
            for(int i=0;i<position-1;i++){
                temp=temp.getNext();
            }
            DoubleNode<T> nodeToRemove = temp.getNext();
            temp.setNext(nodeToRemove.getNext());
        
            if (nodeToRemove.getNext() != null) {
                nodeToRemove.getNext().setPrev(temp);
            }
        }
        itemCount--;
        return null;
    }


    public void clear(){
        head=null;
        itemCount=0;
    }

    public T getEntry(int position){
        if(position<0 || position>itemCount||isEmpty()){
            return null;
        }
        return getNodeAt(position).getItem();
    }

    public T replace(int position, Object entry){
        if(position<0 || position>itemCount||isEmpty()){
            return null;
        }
        DoubleNode<T> temp = head;
        for(int i=0;i<position;i++){
            temp=temp.getNext();
        }
        temp.setItem((T)entry);
        return (T) entry;
    }

    public int getIndexOf(T key){
        DoubleNode<T> temp = head;
        for(int i=0;i<itemCount;i++){
            if(temp.getItem().equals(key)){
                return i;
            }
            temp=temp.getNext();
        }

        return -1;
    }

    public Object[] toArray(){
        Object[] arr = new Object[itemCount];
        DoubleNode<T> temp = head;
        for (int i = 0; i < itemCount; i++) {
            arr[i] = temp.getItem();
            temp = temp.getNext();
        }

        return arr;
    }

    private DoubleNode<T> getNodeAt(int position){
        DoubleNode<T> temp = head;
        for(int i=0;i<position;i++){
            temp=temp.getNext();
        }

        return temp;
    }

    public String toString(){
        if(isEmpty()){
            return "Empty List";
        }
        DoubleNode<T> temp = head;
        String str = "";
        for(int i=0;i<itemCount;i++){
            str+=temp.getItem().toString()+" ";
            temp=temp.getNext();
        }
        return str;
    }






















}
