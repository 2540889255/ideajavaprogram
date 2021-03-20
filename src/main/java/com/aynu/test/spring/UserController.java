package com.aynu.test.spring;


import java.lang.reflect.Field;

public class UserController {


    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        UserController userController=new UserController();
        Class<? extends UserController> userControllerClass = userController.getClass();
        Field[] fields = userControllerClass.getDeclaredFields();
        for (Field field:fields
             ) {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation!=null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object o = type.newInstance();
                field.set(userController,o);
            }
        }
        System.out.println(userController.getUserService().toString());
    }
}
