package com.aynu.test.letcode;

/**
 *
 * 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。 
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author admin
 */
public class letcode33 {


    public static void main(String[] args) throws InterruptedException {
        int i = firstBadVersion(5);
        System.out.println(i);
    }

    public static int firstBadVersion(int n) throws InterruptedException {
        int left=1;
        int end =n;
        int middle=0;
        while (left<end){
            middle=left+(end-left)/2;

            if (isBadVersion(middle)){
                end=middle;
            }else {
                left=middle+1;
            }
        }
        return left;
    }

    public static int firstBadVersion1a(int n) throws InterruptedException {

        if (n==1){
            return 1;
        }
        if (n==2){
            boolean badVersion = isBadVersion(1);
            boolean badVersion1 = isBadVersion(2);
            if (badVersion){
                return 2;
            }else {
                return 1;
            }
        }
        boolean result=true;
        int middle=0;
        int start=1;
        int end=n;
        while (result||isBadVersion((start+end)/2-1)||!isBadVersion((start+end)/2+1)){
            middle=(start+end)/2;
            Thread.sleep(1000);
            System.out.println(middle);
            result=isBadVersion(middle);
            if (result){
                end=middle;
            }else {
                start=middle;
                if ((start+end)/2-1>=0){
                    return middle;
                }
            }
        }
        return middle;


    }
    public static int firstBadVersion1(int n) {
        boolean result=true;
        while (result){
            result = isBadVersion(n);
            if (!result){
                return n+1;
            }
            n--;

        }
        return 0;
    }

    public static boolean isBadVersion(int a){
        if (a>2){
            return true;
        }
        return false;
    }
}
