package com.aynu.test.testVM;

/**
 * VM Args: -Xss128k
 * @author lc
 */
public class JavaVMStackSOF {

    private int  stacklength=1;

    public void stackLeak(){
        stacklength++;
        stackLeak();
    }
    //Exception in thread "main" java.lang.StackOverflowError
    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF=new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        }catch (Throwable throwable){
            System.out.println("当前stacklength为"+javaVMStackSOF.stacklength);
            throw throwable;
        }
    }
}
