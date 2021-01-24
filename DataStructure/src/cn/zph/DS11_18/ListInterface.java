package cn.zph.DS11_18;

public interface ListInterface<T> {
    public boolean isEmpty();
    public void printList();
    public int length();
    public int locate(T element);
    public T getElement(int i);
    public void insert(int i,T element);
    public T delete(int i);

}
