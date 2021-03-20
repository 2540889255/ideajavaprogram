package com.aynu.test.letcode;

/**
 * @Auther: LC
 * @Date : 2021 03 06 18:50
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 *
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 */
public class Letcodesward18 {

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(4);
        ListNode listNode1 = deleteNode(listNode, 1);
        System.out.println(1);
    }

    public static ListNode deleteNode(ListNode head, int val) {

        if (head.val==val){
            return head=head.next;

        }
        ListNode root=head;

        while (root.next!=null){
            if (root.next.val==val){
                root.next=root.next.next;
                break;
            }
            root=root.next;
        }
        return head;
    }

    public  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
