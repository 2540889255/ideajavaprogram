package com.aynu.test.letcode;

/**
 * @author admin
 */
public class letcode26 {


    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {

        if (root==null){
            return 0;
        }else {
            int leftNode = maxDepth(root.left);
            int rightNode = maxDepth(root.right);
            return Math.max(leftNode,rightNode)+1;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
