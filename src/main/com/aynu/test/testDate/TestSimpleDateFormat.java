package main.com.aynu.test.testDate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task=new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //return simpleDateFormat.parse("20161218");
                return TestDateFormatThreadLocal.convert("20161218");
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<Future<Date>> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(executorService.submit(task));
        }


        for (Future<Date> future:list
             ) {
            System.out.println(future.get());
        }
        /*list.stream()
                .forEach(x-> {
                    try {
                        x.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });*/
        executorService.shutdown();
    }
    @Test
    public void  testnew() throws ExecutionException, InterruptedException {

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task=new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                //return simpleDateFormat.parse("20161218");
                return LocalDate.parse("20161218",dateTimeFormatter);
            }
        };

        ExecutorService executorService= Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(executorService.submit(task));
        }


        for (Future<LocalDate> future:list
        ) {
            System.out.println(future.get());
        }
        /*list.stream()
                .forEach(x-> {
                    try {
                        x.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });*/
        executorService.shutdown();
    }
}
