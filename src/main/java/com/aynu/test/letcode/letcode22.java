package com.aynu.test.letcode;

/**
 * @author admin
 */
public class letcode22 {

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode.val);
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {


        ListNode listNode1=head;

        ListNode listNode2=head;


        for (int i = 0; i < n-1; i++) {
            listNode1=listNode1.next;
        }

        while (listNode1.next!=null){
            listNode1=listNode1.next;
            listNode2=listNode2.next;
        }

        listNode2.val=listNode2.next.val;
        listNode2.next=listNode2.next.next;
        return head;

    }


    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        boolean size=true;
        ListNode heads=head;
        while (size){
            for (int i = 0; i < n; i++) {
                heads=heads.next;
            }
            if (heads.next==null){
                size=false;
            }
        }
        heads.val=heads.next.val;
        heads.next=heads.next.next;
        return head;
    }



    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
