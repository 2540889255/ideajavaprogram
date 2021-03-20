package com.aynu.test.letcode;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 08 20:22
 * @Description : com.aynu.test.letcode
 * @Version 1.0
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 */
public class letcodesward26 {

    boolean result=false;
    public static void main(String[] args) {

    }

    /**
     *
     **/
    @Test
    public void test() {
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(5);
        treeNode.left.left=new TreeNode(1);
        treeNode.left.right=new TreeNode(2);

        TreeNode treeNodeB=new TreeNode(4);
        treeNodeB.left=new TreeNode(1);
        boolean subStructure = isSubStructure(treeNode, treeNodeB);
        System.out.println(subStructure);
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A==null||B==null){
            return true;
        }
        if(A.val==B.val){
            //节点头相同开始内层判断
            result=cheak(A,B);
            System.out.println(result);
            if (result==true){
                return true;
            }
        }
        isSubStructure(A.left,B);
        isSubStructure(A.right,B);
        return result;
    }

    public boolean cheak(TreeNode A,TreeNode B){
        if(A==null&&B==null||(A!=null&&B==null)){
            return true;
        }
        if(A.val!=B.val){
            return false;
        }
        boolean aresult=cheak(A.left,B.left);
        boolean bresult=cheak(A.right,B.right);
        return aresult && bresult;
    }


    @Test
    public void test2(){
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(4);


        TreeNode treeNodeB=new TreeNode(2);
        treeNodeB.left=new TreeNode(4);
        System.out.println(cheak(treeNode, treeNodeB));

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
