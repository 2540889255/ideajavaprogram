package com.aynu.test.test;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 05 21:11
 * @Description : com.aynu.test.test
 * @Version 1.0
 *
 * 测试计算机的进制
 */
public class ByteDemo {

    public static void main(String[] args) {

        /*11111111111111111111111110000001
        测试完，个人总结，int最大值为2147483647，这个数字，并不是int类型的四个字节，32位的，而是31位，最后的32号位置，用作了符号位置
        1，代表了数字的符号位置，从-1可以看出来，
        然后测试了long类型的-1，可以看到一共是64位1,
        由int类型可以推测，long类型的最大值为63位
        * */

        int maxValue = Integer.MAX_VALUE;
        System.out.println("int 最大值为"+maxValue);
        System.out.println(Integer.toBinaryString(maxValue));
        System.out.println(Integer.toBinaryString(maxValue).length());
        long c=(long) maxValue;
        c++;
        System.out.println(c);
        System.out.println(Long.toBinaryString(c));
        System.out.println("------------------------------------");

        int a=-1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a).length());
        int a2=-2147483647;
        System.out.println(Integer.toBinaryString(a2));
        System.out.println(Integer.toBinaryString(a2).length());

        System.out.println("-------------------------------------");
        long maxValue1 = Long.MAX_VALUE;
        System.out.println("long类型的最大值的二进制"+Long.toBinaryString(maxValue1));
        System.out.println("long类型的最大值的二进制长度"+Long.toBinaryString(maxValue1).length());


        long l=-1;
        System.out.println("long类型的-1的二进制"+Long.toBinaryString(l));
        System.out.println("long类型的-1的二进制长度"+Long.toBinaryString(l).length());

        System.out.println("-----------------------------------------");


    }


    @Test
    public void test(){
        /*
        * 测试byte类型
        * */
        String s=new String("127");
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }


        byte maxValue = Byte.MAX_VALUE;
        System.out.println("byte的最大值"+maxValue);
        System.out.println("byte转换为int类型"+Byte.toUnsignedInt(maxValue));

        /*通过无符号转换将参数转换为int 。
         在无符号转换为一个int ，所述的高阶24位int是零和低位8位都等于的比特byte的参数。
        因此，零byte和正byte值映射到数值上相等的int值，负byte值映射到等于输入加2 8的int值
        * */
        byte minValue = Byte.MIN_VALUE;
        System.out.println("byte的最大值"+minValue);
        System.out.println("byte转换为int类型"+Byte.toUnsignedInt(minValue));//这个值为128因为-128+256=128

        byte c=-127;

        int i = c  & 0xFF;
        int j = minValue & 0xFF;
        System.out.println("-127的二进制"+Integer.toBinaryString(i));
        System.out.println("-127变化后为"+i);
        System.out.println("-128的二进制"+Integer.toBinaryString(j));
        System.out.println("-128变化后为"+j);
        byte d=-127;
        int e=(int) d;

        System.out.println("直接转为int类型对应的编码"+Integer.toBinaryString(e));

    }

    @Test
    public void test2(){
        System.out.println(Integer.toBinaryString(-2147483648*-1));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Long.toBinaryString(-2147483648));
        int a=-2147483648;
        System.out.println(Long.valueOf(a)*-1);



    }

}
