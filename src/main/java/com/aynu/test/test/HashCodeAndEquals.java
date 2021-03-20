package com.aynu.test.test;

import com.aynu.test.testthread.ThreadStartDemo;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @Auther: LC
 * @Date : 2021 03 04 16:18
 * @Description : com.aynu.test.test
 *
 *
 * 彻底搞通equal和hashcode
 * @Version 1.0
 */
public class HashCodeAndEquals {

    int number=0;

    public static void main(String[] args) {

        //创建两个对象，重写equals方法，然后不重写hashcode方法，看看会有什么问题。
        HashCodeAndEquals hashCodeAndEquals=new HashCodeAndEquals();
        System.out.println(hashCodeAndEquals.hashCode());
        HashCodeAndEquals hashCodeAndEquals2=new HashCodeAndEquals();
        System.out.println(hashCodeAndEquals2.hashCode());
        System.out.println(hashCodeAndEquals2.equals(hashCodeAndEquals));

        //使用首先HashMap测试,hashMap不会有重复的元素，这样的话，自定义的equals判断这两个对象相同，在HashMap中却是两个对象
        HashMap<HashCodeAndEquals,HashCodeAndEquals> hashMap=new HashMap();
        hashMap.put(hashCodeAndEquals,hashCodeAndEquals);
        hashMap.put(hashCodeAndEquals2,hashCodeAndEquals2);
        System.out.println(hashMap.size());


    }


    @Test
    public void test(){
        //创建两个对象，重写equals方法，然后不重写hashcode方法，看看会有什么问题。
        HashCodeAndEquals hashCodeAndEquals=new HashCodeAndEquals();
        hashCodeAndEquals.setNumber(1);
        System.out.println(hashCodeAndEquals.hashCode());
        HashCodeAndEquals hashCodeAndEquals2=new HashCodeAndEquals();
        hashCodeAndEquals2.setNumber(2);
        System.out.println(hashCodeAndEquals2.hashCode());
        System.out.println(hashCodeAndEquals2.equals(hashCodeAndEquals));

        //使用首先HashMap测试,两个对象的hashcode值相同，那么他们在hashcode中就是相同的，那么第二个就会覆盖第一个
        HashMap<HashCodeAndEquals,HashCodeAndEquals> hashMap=new HashMap();
        hashMap.put(hashCodeAndEquals,hashCodeAndEquals);
        hashMap.put(hashCodeAndEquals2,hashCodeAndEquals2);
        System.out.println(hashMap.size());


        System.out.println(System.identityHashCode(hashCodeAndEquals));

    }

    @Test
    public void test2(){
        //测试其它类型的equals方法
        String s=new String(" ");
        String s1=new String(" ");

        System.out.println(s==s1);
        System.out.println(s.equals(s1));
        //string的equals，首先判断是否是同一对象，对象的地址是否相同，然后判断是否压缩，compact——Strings，然后调用StringLatin中的equal对比，value，value是一个byte数组，比较数组每一个是否相同

        Integer integer=new Integer(1);
        Integer integer1=new Integer(1);
        System.out.println(integer.equals(integer1));
        /*
        public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
            return false;
        }
        * */


    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        HashCodeAndEquals hashCodeAndEquals=(HashCodeAndEquals)obj;
        if (this.hashCode()==hashCodeAndEquals.hashCode()){
            return true;
        }
        /*if (hashCodeAndEquals.number== this.number){
            return true;
        }*/
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
