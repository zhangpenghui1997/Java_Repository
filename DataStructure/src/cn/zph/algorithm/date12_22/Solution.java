package cn.zph.algorithm.date12_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return  l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode L1 = l1;
        ListNode L2 = l2;

        List<Integer> list = new ArrayList<>();
        do {
            list.add(L1.val);
            L1 = L1.next;
        } while (L1 != null);

        do {
            list.add(L2.val);
            L2 = L2.next;
        } while (L2 != null);

        Collections.sort(list);

        List<ListNode> ls = new ArrayList<>();
        for (int i = 0; i < list.size(); ++i) {
            ListNode e = new ListNode(list.get(i));
            ls.add(e);
        }

        for (int i = 0; i < ls.size(); ++i) {
            if(i<ls.size()-1){
                ls.get(i).next=ls.get(i+1);
            }
        }

        return ls.get(0);
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1, l2);
        ListNode L = l1;

        List<Integer> list = new ArrayList<>();
        do {
            list.add(L.val);
            L = L.next;
        } while (L != null);


    }
}
