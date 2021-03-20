package com.aynu.test.letcode;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode25 {


    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
/*        listNode.next=new ListNode(2);
        listNode.next.next=listNode;*/
        boolean b = hasCycle(listNode);
        System.out.println(b);
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow=head;
        ListNode fast=head.next;

        while (slow!=fast){
            if (fast== null || fast.next == null) {
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;

    }
    public static boolean hasCycle1(ListNode head) {
        if (head==null){
            return false;
        }
        HashMap hashMap=new HashMap();
        int size=0;
        int hashcode=0;
        while (head.next!=null){
            hashcode= head.hashCode();
            size=hashMap.size();
            hashMap.put(head.hashCode(),0);
            if (size==hashMap.size()){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
