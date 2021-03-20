package com.aynu.test.letcode;

import com.aynu.test.Until.LuchenArraysUntil;
import com.aynu.test.testgeneraticity.Luchen;
import org.apache.logging.log4j.core.util.Integers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: LC
 * @Date : 2021 02 27 16:03
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 */
public class LetcodeSward06 {

    static List list=new ArrayList();
    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next=new ListNode(3);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int[] nums = reversePrint(head);
        LuchenArraysUntil.printArrays(nums);

    }

    public static int[] reversePrint(ListNode head) {
        StringBuilder stringBuilder=new StringBuilder();

        while (head!=null){
            stringBuilder.append(head.val);
            head=head.next;
        }

        stringBuilder.reverse();

        String s = stringBuilder.toString();
        int[] nums=new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i]=Integer.valueOf(s.substring(i,i+1));
        }
        return nums;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


  /*使用递归对于链表进行反向输出*/
    @Test
    public void test(){
        ListNode head =null;


        nestsort(head);

        int[] nums=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = (int) list.get(i);
        }
        LuchenArraysUntil.printArrays(nums);
    }

    public static void nestsort(ListNode listNode){

        if (listNode==null){
            return;
        }
        if (listNode!=null){
            nestsort(listNode.next);
            list.add(listNode.val);
        }
    }



}
