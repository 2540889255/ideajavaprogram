package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 *
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode27 {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(4);


        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    /**
     * 递归解决判断是否为二叉搜索树
     * @return
     */
    public static boolean isValidBST(TreeNode root) {

        return  helper(root,null,null);
    }

    public  static boolean helper(TreeNode treeNode,Integer lower,Integer upper){

        if (treeNode==null){
            return true;
        }

        int val=treeNode.val;
        if (val<=lower) {
            return false;
        }
        if (val>=upper){
            return false;
        }

        if (!helper(treeNode.right,val,upper)){
            return false;
        };
        if (!helper(treeNode.left,lower,val)){
            return false;
        }

        return true;
    }



    public static boolean isValidBST4(TreeNode root) {

        Stack<TreeNode> treeNodes=new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while (!treeNodes.isEmpty()||root!=null){

            while (root!=null){
                treeNodes.push(root);
                root=root.left;
            }


            root = treeNodes.pop();
            if (root.val<inorder){
                return false;
            }

            inorder=root.val;

            root=root.right;
        }

        return true;


    }
    public static boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


        public static boolean isValidBST2(TreeNode root) {

       /* System.out.println(root.left.val);
        System.out.println(root.val);
        System.out.println(root.right.val);*/

        if(root.left==null){
            System.out.println(root.val);
            System.out.println(root.right.val);
            return true;
        }else if(root.right==null){
            System.out.println(root.left.val);
            System.out.println(root.val);
            return true;
        }else if(root.left==null&&root.right==null){
            System.out.println(root.val);
            return true;
        }
        else {
            return isValidBST(root.left)&&isValidBST(root.right);
        }
    }


    public static boolean isValidBST1(TreeNode root) {
        if (root==null){
            return true;
        }

        if (root.left==null&&root.right==null){
            return true;
        }else if(root.left==null){
            return root.val<root.right.val;
        }else if(root.right==null){
            return root.left.val<root.val;
        }
        else {
            return root.left.val<root.val&&root.val<root.right.val&&isValidBST(root.left)&&isValidBST(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void show(){
        int a=1;
        int b=2;

        TreeNode treeNode=new TreeNode(3);
        treeNode.left=null;
        treeNode.right=new TreeNode(4);
        System.out.println(treeNode.left.val<treeNode.right.val);
        System.out.println(a<=2);
    }
}
