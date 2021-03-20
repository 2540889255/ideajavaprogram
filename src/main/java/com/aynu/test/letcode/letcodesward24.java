package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 07 18:25
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class letcodesward24 {

    int sum=0;

    ListNode last;
    public static void main(String[] args) {

    }

    /*直接遍历循环的算法*/
    public ListNode reverseList2(ListNode head) {

        ListNode pre=null;

        ListNode current=head;

        while (current!=null){
            head=current.next;

            current.next=pre;

            pre=current;

            current=head;
        }
        return pre;
    }
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return head;
        }
        if (head.next==null){
            last=head;
            return head;
        }
        ListNode end = reverseList(head.next);
        head.next=null;
        last.next=head;
        last=last.next;
        System.out.println(sum);
        return end;
    }

    /**
     *
     **/
    @Test
    public void test() {
        ListNode head =new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode listNode = reverseList2(head);
        System.out.println(listNode.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*public ListNode reverseList(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode end = reverseList(head.next);
        ListNode ens = end;
        while (ens.next!=null){
            ens=ens.next;
            sum++;
        }
        head.next=null;
        ens.next=head;
        System.out.println(sum);
        return end;
    }*/
}
