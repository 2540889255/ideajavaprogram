package com.aynu.test.testgeneraticity;

import java.util.List;


public class LuchenService {


    public UserDO<UserVO>  getUserVO(){
        LuchenDao userDao=new LuchenDao();
        List<UserVO> userVo = userDao.getUserVo();
        int size = userVo.size();
        long lenth=(long)size;
        return new UserDO<UserVO>(lenth,userVo);
    }
}
