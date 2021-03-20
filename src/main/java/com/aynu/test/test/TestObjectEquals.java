package com.aynu.test.test;

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.util.Objects;

/**
 * @author admin
 */
public class TestObjectEquals {


    public static void main(String[] args) {

        Object object=new Object();

        System.out.println(object.equals(new Object()));

        System.out.println(Objects.equals(null,null));

        System.out.println(Objects.equals(1,1));

        System.out.println(null==null);
    }
}
