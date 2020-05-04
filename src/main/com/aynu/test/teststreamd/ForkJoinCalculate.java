package main.com.aynu.test.teststreamd;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private  static final  long serialVersionUID=134656970987L;

    private  long start;

    private  long end;


    private static  final long THRESHOLD =10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length =start-end;
        long sum=0;
        if (length<THRESHOLD){
            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else {
            Long middle=(start+end)/2;
            ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
            left.fork();//拆分子任务   同时加入线程队列
            ForkJoinCalculate right=new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }

    }
}
