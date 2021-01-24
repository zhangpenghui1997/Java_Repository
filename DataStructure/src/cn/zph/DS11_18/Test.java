package cn.zph.DS11_18;

public class Test {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        for (int i = 0; i < 10; ++i) {
            array[i] = i;
        }
        LinkedList<Integer> L = new LinkedList<>(array);
        L.printList();
        System.out.println("\n链表的长度：" + L.length());
        L.delete(10);
        L.printList();
        System.out.println("\n链表的长度：" + L.length());
        System.out.println(L.getElement(1));
        L.delete(2);
        System.out.println("元素5的位置："+L.locate(5));
        System.out.println("********插入之前：************");
        L.printList();
        L.insert(0,5);
        System.out.println("\n**********插入之后：************");
        L.printList();
    }
}
