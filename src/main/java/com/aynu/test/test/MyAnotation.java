package com.aynu.test.test;

import com.aynu.test.spring.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.validation.Validator;
import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Auther: LC
 * @Date : 2021 02 11 16:50
 * @Description : com.aynu.test.test
 * @Version 1.0
 */
@LuchenClass(value = "Luchen")
public class MyAnotation {

    @LuchenField(name = "路")
    private String name;




    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.aynu.test.test.MyAnotation");

        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("输出类的注解-------");

        for (Annotation a :annotations
            ) {
            System.out.println("注解的信息"+a);
            System.out.println("注解的类型"+a.annotationType());
        }

        System.out.println("输出类的属性的信息---------------");
        Field name = aClass.getDeclaredField("name");

        Annotation[] fieldAnnotation = name.getAnnotations();

        for (Annotation a :fieldAnnotation
            ) {
            System.out.println("属性的注解的信息"+a);
            System.out.println("属性的注解类型"+a.annotationType());
        }


    }



}



@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface LuchenClass{

    String value() default "";

    String name() default "";
}

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface LuchenField{
    String name() default "";

    String size() default "";

}