package com.aynu.test.letcode;

import java.util.Stack;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode28 {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(2);
        /*root.left.right=new TreeNode(4);*/
        /*root.right.left=new TreeNode(2);*/
        root.right.right=new TreeNode(2);


        boolean validBST = isSymmetric(root);
        System.out.println(validBST);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }



    public static boolean isSymmetric1(TreeNode root) {


        StringBuffer stringBuffer=new StringBuffer();

        Stack<TreeNode> stack=new Stack<>();



        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            stringBuffer.append(root.val);

            root=root.right;


        }

        StringBuffer reverse = new StringBuffer(stringBuffer);



        if (reverse.toString().equals(stringBuffer.reverse().toString())){
            return true;
        }

        return false;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
