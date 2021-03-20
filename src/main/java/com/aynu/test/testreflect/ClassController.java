package com.aynu.test.testreflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author admin
 */
public class ClassController {

    private ClassService service;

    public ClassService getService() {
        return service;
    }

    public void setService(ClassService service) {
        this.service = service;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        ClassController classController=new ClassController();
        Class<? extends ClassController> aClass = classController.getClass();

        Method setService = aClass.getMethod("setService", ClassService.class);
        setService.setAccessible(true);

        ClassService classService=new ClassService();
        System.out.println(classService.toString());
        Object invoke = setService.invoke(classController, classService);
        System.out.println(classController.getService().toString());

    }

    @Test
    public void show() throws NoSuchFieldException, IllegalAccessException {
        ClassController classController=new ClassController();
        Class<? extends ClassController> aClass = classController.getClass();

        Field service = aClass.getField("service");
        service.setAccessible(true);


        ClassService classService=new ClassService();
        System.out.println(classService.toString());

        service.set(classController,classService);

        System.out.println(classController.getService().toString());
    }

    @Test
    public void shows() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        ClassController classController=new ClassController();
        Class<? extends ClassController> aClass = classController.getClass();

        Field service = aClass.getDeclaredField("service");
        service.setAccessible(true);

        String name = service.getName();
        System.out.println(name);

        name="set"+name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        System.out.println(name);
        ClassService classService=new ClassService();
        Method method = aClass.getMethod(name, ClassService.class);
        method.invoke(classController,classService);
        System.out.println(classController.getService());

    }
}
