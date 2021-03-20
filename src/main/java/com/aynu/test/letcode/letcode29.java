package com.aynu.test.letcode;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author admin
 */
public class letcode29 {


    @Test
    public void show(){

        int a=Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(++a);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(4);
        levelOrder(root);
    }



    public static List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>>  lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        List<Integer> list;

        Queue<TreeNode> queue=new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
                list.add(poll.val);
            }
            lists.add(list);
        }
        return lists;
    }
    public static List<List<Integer>> levelOrder1(TreeNode root) {

        Stack<TreeNode> stackPre=new Stack<TreeNode>();
        Stack<TreeNode> stackLas=new Stack<TreeNode>();

        stackPre.add(root);
        List<List<Integer>>  lists=new ArrayList<>();
        if (root==null){
            return lists;
        }
        List<Integer> list;
        int sign=0;
        while (!stackPre.isEmpty()||!stackLas.isEmpty()){
            list=new ArrayList<>();
            if (sign==0){
                while (!stackPre.isEmpty()){
                    TreeNode pop = stackPre.pop();
                    list.add(pop.val);
                    if (pop.right!=null){
                        stackLas.add(pop.right);
                    }if (pop.left!=null){
                        stackLas.add(pop.left);
                    }
                }
                sign=1;
            }else {
                while (!stackLas.isEmpty()){
                    TreeNode pop = stackLas.pop();
                    list.add(pop.val);
                    if (pop.right!=null){
                        stackPre.add(pop.right);
                    }if (pop.left!=null){
                        stackPre.add(pop.left);
                    }
                }
                sign=0;
            }

            lists.add(list);
        }

        return  lists;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
