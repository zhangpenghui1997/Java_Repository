package cn.zph.DS11_18;

public class LinkedNode<T> {
    private T data;
    private LinkedNode<T> next;

    public LinkedNode() {
        this.data = null;
        this.next = null;
    }

    public LinkedNode(T element) {
        this.data = element;
        this.next = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T element) {
        this.data = element;
    }

    public LinkedNode<T> getNext(){
        return this.next;
    }

    public void setNext(LinkedNode<T> linkedNode){
        this.next=linkedNode;
    }
}


