package com.aynu.test.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
public class JMHTest {

    @State(Scope.Benchmark)
    public static class SharedStat{

        @Setup(Level.Iteration)
        public void showInformation(){
            System.out.println("welcome to this place");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 1)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public double  f(SharedStat sharedStat){
        return Math.log(Math.PI);
    }

    public static void main(String[] args) {
        System.out.println(JMHTest.class.getSimpleName());
        Options options=new OptionsBuilder().include(JMHTest.class.getSimpleName())
                .result("D:jmh_result")
                .resultFormat(ResultFormatType.JSON)
                .build();
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
