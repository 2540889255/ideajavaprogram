package main.com.aynu.test.testDate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * 一共三种   localdate  localtime  localdatetime
 */
public class TestLocalDateTime {

    //时区格式
    @Test
    public void testZoonTIme(){
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.forEach(System.out::println);
    }

    //DateTimeFormatter
    @Test
    public void testDataTimeFormatter(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ISO_LOCAL_DATE;//.ISO_DATE_TIME;
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime);
        String format = dateTime.format(dateTimeFormatter);
        System.out.println(format);
        //自定义自己的格式时间器
        DateTimeFormatter dateTimeFormatter1=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dateTime.format(dateTimeFormatter1));

    }

    //时间矫正器TemporalAdjust  ::时间矫正器
    @Test
    public void testTemporalAdjust(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(localDateTime2);
    }

    //duration  计算两短时间之内的时间间隔
    //period    计算两段日期之间的间隔
    @Test
    public void testInstant(){
        Instant now = Instant.now();
        System.out.println(now);  //默认时区  世界协调时间  UTC
    }
    @Test
    public void testLocalDateTime(){

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);


        System.out.println(localDateTime.plusYears(3));
    }
}
