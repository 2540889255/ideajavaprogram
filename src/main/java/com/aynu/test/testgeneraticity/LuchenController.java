package com.aynu.test.testgeneraticity;

public class LuchenController {


    public static void main(String[] args) {
        LuchenService userService=new LuchenService();

        UserDO<UserVO> userVO = userService.getUserVO();


        /*Long length = userVO.getLength();

        userVO.getUsers();
        System.out.printf(length.toString());*/
    }
}
