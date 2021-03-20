package com.aynu.test.exam;

import org.junit.jupiter.api.Test;

/**
 * @Auther: LC
 * @Date : 2021 03 18 19:04
 * @Description : com.aynu.test.exam
 * @Version 1.0
 */
public class Main20210118 {

    public static void main(String[] args) {

    }

    /**
     *
     **/
    @Test
    public void test() {
        System.out.println(calcSimilarity("Zhang San", "Zhan Ai"));
    }


    static int calcSimilarity(String name1, String name2) {

        int number=0;

        char[] namechars1 = name1.toCharArray();
        char[] namechars2 = name2.toCharArray();

        int lenght=namechars1.length>namechars2.length?namechars2.length:namechars1.length;

        int sizename1=0;
        int sizename2=0;
        for (int i = 0; i < lenght; i++) {
            if (sizename1>=20 || sizename2>=20){
                break;
            }
            if (namechars1[i]==namechars2[i]){

            }else {
                if (namechars1[i]==' '){
                    sizename1++;
                    number+=0;
                }else {
                    number+=namechars1[i];
                }
                if (namechars2[i]==' '){
                    sizename2++;
                    number+=0;
                }else {
                    number+=namechars2[i];
                }

                System.out.println("类型为"+namechars1[i]+""+(int)namechars1[i]);
                System.out.println("类型为"+namechars2[i]+""+(int)namechars2[i]);

            }
        }

        if (namechars1.length>lenght){
            for (int i = lenght; i < namechars1.length; i++) {
                if (sizename1>=20||sizename2>=20){
                    break;
                }
                System.out.println("类型为"+namechars1[i]+""+(int)namechars1[i]);
                number+=namechars1[i];
                sizename1++;
            }
        }else {
            for (int i = lenght; i < namechars2.length; i++) {
                if (sizename1>=20||sizename2>=20){
                    break;
                }
                System.out.println("类型为"+namechars2[i]+""+(int)namechars2[i]);
                number+=namechars2[i];
                sizename2++;
            }
        }
        return number;
    }


    public int count(String name,String name2){

        int sum=0;

        char[] chars = name.toCharArray();
        char[] chars2 = name2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum+=chars[i];
        }
        System.out.println("1 number"+sum);
        for (int i = 0; i < chars2.length; i++) {
            sum+=chars2[i];
        }

        return sum;
    }

}
