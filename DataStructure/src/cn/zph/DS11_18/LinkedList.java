package cn.zph.DS11_18;


public class LinkedList<T> implements ListInterface<T> {
    private LinkedNode<T> first;

    public LinkedList() {
        first = new LinkedNode<T>();
    }

    public LinkedList(T[] init) {
        first = new LinkedNode<T>();
        LinkedNode<T> rear = first;
        for (int i = 0; i < init.length; ++i) {
            LinkedNode<T> node = new LinkedNode<>(init[i]);
            rear.setNext(node);
            rear = node;
        }
    }

    @Override
    public boolean isEmpty() {
        LinkedNode<T> p = first.getNext();
        while (p != null) {
            return false;
        }
        return true;
    }

    @Override
    public void printList() {
        if (isEmpty()) {
            System.out.println("链表为空");
        } else {
            System.out.println("链表的元素为：");
            LinkedNode<T> p = first.getNext();
            while (p != null) {
                System.out.print(p.getData() + " ");
                p = p.getNext();
            }
        }
    }

    @Override
    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            int length = 0;
            LinkedNode<T> p = first.getNext();
            while (p != null) {
                length += 1;
                p = p.getNext();
            }
            return length;
        }

    }

    @Override
    public int locate(T element) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return -2;
        } else {
            int index = 0;
            LinkedNode<T> p = first.getNext();
            while (p != null) {
                if (p.getData() == element) {
                    return index;
                }
                p = p.getNext();
                index += 1;
            }
            System.out.println("元素不存在");
            return -1;
        }
    }

    @Override
    public T getElement(int i) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return null;
        } else if (i < 0) {
            System.out.println("位置不合法");
            return null;
        } else {
            LinkedNode<T> p = first.getNext();
            for (int j = 0; j < i; ++j) {
                p = p.getNext();
            }
            return p.getData();
        }
    }

    @Override
    public void insert(int i, T element) {
        if (i < 0 || i > length() - 1) {
            System.out.println("位置不合法");
            return;
        } else {
            LinkedNode<T> p = first;
            for (int j = 0; j < i; ++j) {
                p = p.getNext();
            }
            LinkedNode<T> p1 = p.getNext();
            LinkedNode<T> node = new LinkedNode<>(element);
            p.setNext(node);
            node.setNext(p1);
        }
    }

    @Override
    public T delete(int i) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return null;
        } else if (i < 0 || i > length() - 1) {
            System.out.println("删除的位置不合法");
            return null;
        } else {
            LinkedNode<T> p = first;
            for (int j = 0; j < i; ++j) {
                p = p.getNext();
            }
            LinkedNode<T> p1 = p.getNext(); ///待删除的节点
            p.setNext(p1.getNext());
            return p1.getData();
        }
    }
}
