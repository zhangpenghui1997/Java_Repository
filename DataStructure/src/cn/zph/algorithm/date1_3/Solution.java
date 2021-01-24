package cn.zph.algorithm.date1_3;

import cn.zph.algorithm.date1_3.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode h1 = head;

        while (h1.val != x) {
               h1=h1.next;
        }
        ListNode h2 = h1;
        while(h2.next!=null){
            if(h2.val>h1.val){

            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next = l1;
        ListNode h1 = head;

        while (h1 != null) {
            System.out.println(h1.val);
            h1 = h1.next;
        }

    }
}
