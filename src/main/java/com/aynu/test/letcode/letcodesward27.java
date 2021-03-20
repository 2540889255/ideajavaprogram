package com.aynu.test.letcode;

import kotlin.contracts.ReturnsNotNull;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @Auther: LC
 * @Date : 2021 03 09 11:45
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class letcodesward27 {

    TreeNode template;
    public static void main(String[] args) {

    }

    /*借用栈结构对于二叉树数组的镜像进行处理*/
    public TreeNode mirrorTree2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left!=null){
                stack.add(node.left);
            }
            if (node.right!=null){
                stack.add(node.right);
            }
            template=node.left;
            node.left=node.right;
            node.right=template;
        }
        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        if(root.left==null && root.right==null){
            return root;
        }

        TreeNode llast=mirrorTree(root.left);
        TreeNode rlast=mirrorTree(root.right);
        root.left=rlast;
        root.right=llast;
        return root;
    }

    /**
     *
     **/
    @Test
    public void test() {

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
