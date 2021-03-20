package com.aynu.test.letcode;

import com.aynu.test.testIo.IdleStateHandlerInitializer;
import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 08 12:41
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Letcodesward25 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode result=listNode;
        while (l1!=null && l2!=null){
            if (l1.val>l2.val){
                listNode.next=l2;
                l2=l2.next;
            }else{
                listNode.next=l1;
                l1=l1.next;
            }
            listNode=listNode.next;


        }
        listNode.next=l1==null? l2 : l1;

        return result.next;
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
        ListNode head1 =new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(3);
        head1.next.next.next=new ListNode(4);
        head1.next.next.next.next=new ListNode(5);
        ListNode listNode = mergeTwoLists(head,head1);
        System.out.println(listNode.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
