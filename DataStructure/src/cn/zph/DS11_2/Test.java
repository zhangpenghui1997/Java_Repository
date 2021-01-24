package cn.zph.DS11_2;

public class Test {
    public static void main(String[] args) {
     /*   SequentialList<Integer> list=new SequentialList<>();
        list.insert(1,1);
        list.insert(2,2);
        list.printList();
        list.delete(1);
        System.out.println("长度为："+list.length());*/
        String[] s = {"a", "b", "c", "d", "e", "f", "g"};
     SequentialList<String> strList=new SequentialList<>(s,s.length);
    // strList.printList();
     strList.delete(1);
     strList.printList();
        //System.out.println(strList.locate("c"));

    }
}
