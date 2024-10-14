public class Finger<T> {
    private DoubleNode<T> node;
    private int idx;

    Finger(int idx, DoubleNode<T> node){
        this.idx=idx;
        this.node=node;

    }

    public DoubleNode<T> getNode() {
        return node;
    }

    public void setNode(DoubleNode<T> node) {
        this.node = node;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
    

    
    
}
