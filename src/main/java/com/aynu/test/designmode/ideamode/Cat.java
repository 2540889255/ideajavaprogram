package com.aynu.test.designmode.ideamode;

import com.aynu.test.test.SortUntil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: LC
 * @Date : 2021 02 23 18:29
 * @Description : com.aynu.test.designmode.ideamode
 * @Version 1.0
 */
public class Cat implements Comparable {

    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public int compareTo(@NotNull Object o) {
        Cat cat=(Cat) o;
        if (this.size> cat.size) {
            return 1;
        } else if (this.size<cat.size) {
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Cat cat=new Cat();
        Cat cat1=new Cat();
        Cat cat2=new Cat();
        Cat cat3=new Cat();

        cat.setSize(1);
        cat1.setSize(2);
        cat2.setSize(3);
        cat3.setSize(4);
        Comparable[] cats={cat1,cat,cat3,cat2};
        SortUntil.compares(cats);
        Arrays.stream(cats).forEach(System.out::print);
    }


}
