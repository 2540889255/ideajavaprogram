package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 07 16:50
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class letcodesward22 {

    static int sum=0;
    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode end = getKthFromEnd(head, 3);
        System.out.println(end);
    }


    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head==null){
            return head;
        }

        ListNode end = getKthFromEnd(head.next, k);
        sum++;
        if (sum==k){
            return head;
        }
        return end;
    }
    /**
     *
     **/
    @Test
    public void test() {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
