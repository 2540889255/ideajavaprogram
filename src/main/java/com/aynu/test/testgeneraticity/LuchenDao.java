package com.aynu.test.testgeneraticity;

import java.util.ArrayList;
import java.util.List;

public class LuchenDao {


    public List<UserVO> getUserVo(){

        List<UserVO> list =new ArrayList<UserVO>();
        UserVO userVO1=new UserVO();
        UserVO userVO2=new UserVO();
        UserVO userVO3=new UserVO();
        UserVO userVO4=new UserVO();
        UserVO userVO5=new UserVO();
        list.add(userVO1);
        list.add(userVO2);
        list.add(userVO3);
        list.add(userVO4);
        list.add(userVO5);
        return list;
    }
}
