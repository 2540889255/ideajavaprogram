package com.aynu.test.letcode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * Java
 *
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode24 {

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(4);

        ListNode listNode2=new ListNode(1);
        listNode2.next=new ListNode(3);
        listNode2.next.next=new ListNode(4);

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null){
            return l1;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode listNode=new ListNode(0);


        ListNode lastNode=listNode;
        while (true){
            if (l1.val<=l2.val){
                lastNode.next=l1;
                if (l1.next==null){
                    lastNode.next.next=l2;
                    break;
                }
                l1=l1.next;
            }else {
                lastNode.next=l2;
                if (l2.next==null){
                    lastNode.next.next=l1;
                    break;
                }
                l2=l2.next;
            }
            lastNode=lastNode.next;
        }
        listNode=listNode.next;
        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void show(){
        /*if (l1.next==null&&l2.next==null){
            if (l1.val<=l2.val){
                l1.next=l2;
                lastNode.next=l1;
            }else {
                l2.next=l1;
                lastNode.next=l2;
            }
        }
        else  if (l1.next==null){

        }*/
        /*if (l1.next==null) {
            if (l1.next==null&&l2.next==null){
                if (l1.val<=l2.val){
                    l1.next=l2;
                    lastNode.next=l1;
                }else {
                    l2.next=l1;
                    lastNode.next=l2;
                }

            }else {
                lastNode.next = l2;
            }
        }else {
            if (l1.next==null&&l2.next==null){
                if (l1.val<=l2.val){
                    l1.next=l2;
                    lastNode.next=l1;
                }else {
                    l2.next=l1;
                    lastNode.next=l2;
                }

            }else {
                lastNode.next = l1;
            }

        }
*/
    }
}
