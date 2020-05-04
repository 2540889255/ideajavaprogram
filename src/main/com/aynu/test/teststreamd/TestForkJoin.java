package main.com.aynu.test.teststreamd;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class TestForkJoin {
    /**
     * 这是 forkjoin框架
     */
    @Test
    public void testfork(){
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinCalculate forkJoinCalculate=new ForkJoinCalculate(0,100000000L);
        long sum=forkJoinPool.invoke(forkJoinCalculate);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).getNano());
    }
    /**
     * 这是普通的方法
     */
    @Test
    public void testordinary(){
        Long sum=0L;
        Instant start = Instant.now();
        for (long i=0;i<=100000000L ;i++){
            sum+=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).getNano());
    }
    /**
     * java8 并行流
     */
    @Test
    public void  test(){
        Instant start = Instant.now();
        OptionalLong reduce = LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(Long::sum);
        System.out.println(reduce.getAsLong());
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).getNano());

    }
}
