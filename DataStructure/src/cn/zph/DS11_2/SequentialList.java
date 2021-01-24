package cn.zph.DS11_2;

public class SequentialList<T> implements ListInterface<T> {
    private T[] list;
    private final static int LIST_SIZE = 100;
    private int length;

    public SequentialList() {
        this.list = (T[]) (new Object[LIST_SIZE]);
        this.length = 0;
    }
    public SequentialList(T[] s,int n){
        this.list = (T[]) (new Object[LIST_SIZE]);
        this.length = 0;
        if(n>LIST_SIZE){
           return;
        }else{
           for(int i=0;i<n;++i){
               list[i]=s[i];
           }
           length=n;
        }

    }

    @Override
    public void printList() {
        if (isEmpty()) {
            System.out.println("空表");
        } else {
            for (int i = 0; i < length; ++i) {
                System.out.println(list[i]);
            }
        }

    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int locate(T element) {
        if (isEmpty()) {
            return -1;
        } else {
            int flag = -1;
            for (int i = 0; i < length; ++i) {
                if (list[i] == element) {
                    flag = i + 1;
                    break;
                }
            }
            return flag;
        }

    }

    @Override
    public T getElement(int i) {
        if (i > length) {
            System.out.println("越界");
            return null;
        } else {
            return list[i - 1];
        }
    }

    @Override
    public void insert(int i, T element) {
        if (length == LIST_SIZE) {
            System.out.println("已满，无法进行插入");
        } else if (i <= 0 || i > length + 1) {
            System.out.println("插入的位置非法");
        } else {


            for (int j = length; j >= i; --j) {
                list[j] = list[j - 1];
            }
            list[i - 1] = element;
            length++;
            System.out.println("插入成功");

        }
    }

    @Override
    public T delete(int i) {
        if (isEmpty()) {
            System.out.println("表为空，无法进行删除");
            return null;
        } else if (i < 0 || i > length) {
            System.out.println("越界，无法进行删除");
            return null;
        } else {
            T result = list[i - 1];
            for (int j = i - 1; j < length - 1; ++j) {
                list[j] = list[j + 1];
            }
            length--;
            return result;
        }
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }
}
