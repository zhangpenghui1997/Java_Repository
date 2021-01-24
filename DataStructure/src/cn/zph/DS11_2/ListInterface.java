package cn.zph.DS11_2;

public interface ListInterface<T> {
    public void printList();//遍历线性表
    public int length();//求线性表的长度
    public int locate(T element);//按位置查找
    public T getElement(int i);//按位查找
    public void insert(int i,T element);//在指定逻辑位插入
    T delete(int i);//删除指定逻辑位元素
    public boolean isEmpty();//判断表是否为空

}
