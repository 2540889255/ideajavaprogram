package com.aynu.test.letcode;

/**
 * @author admin
 */
public class letcode23 {


    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        /*head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);*/

        ListNode listNode = reverseList(head);
        System.out.println(listNode.val);
    }


    public static ListNode reverseList(ListNode head) {
        ListNode listNode=head;

        if (head==null){
            return head;
        }
        while (listNode.next!=null){
            listNode=listNode.next;
        }

        ListNode lastnode=listNode;
        while (head!=listNode){

            lastnode=head;
            head=head.next;
            lastnode.next=listNode.next;
            listNode.next=lastnode;
            /*listNode.next=head;
            lastnode=listNode.next;
            listNode.next.next=lastnode;
            head=head.next;*/
        }

        return head;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
