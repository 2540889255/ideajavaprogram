package com.aynu.test.letcode;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处
 *
 * @author admin
 */
public class letcode30 {


    public static void main(String[] args) {
        int [] nums={-10,-3,0,5,9};


    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0,nums.length-1);

    }

    public static TreeNode helper(int [] nums,int left,int right){

        if (left>right){
            return null;
        }
        int middle=(left+right)/2;
        TreeNode treeNode=new TreeNode(nums[middle]);
        helper(nums,left,middle-1);
        helper(nums,middle+1,left-1);
        return treeNode;

    }

    /*public int add(TreeNode treeNode, int [] nums, int middle){

        if (middle==0){
            return treeNode.left.val=nums[middle];
        }

        return add(treeNode,nums,middle/2);
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
