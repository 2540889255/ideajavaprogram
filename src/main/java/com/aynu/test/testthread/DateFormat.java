package com.aynu.test.testthread;

import com.mysql.cj.exceptions.DataReadException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: LC
 * @Date : 2021 02 10 15:20
 * @Description : com.aynu.test.testthread
 * @Version 1.0
 */
public class DateFormat {


    public static void main(String[] args) {

        Date date=new Date(System.currentTimeMillis());

        System.out.println(date);

        String format = new SimpleDateFormat("YYYY:MM:HH:mm:ss").format(date);
        System.out.println(format);

    }
}
