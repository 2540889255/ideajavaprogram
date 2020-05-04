package main.com.aynu.test.testVM;

public class ReferenceCountingGC {
    public Object instance =null;

    private static final int _1M=1024*1024;

    public static void main(String[] args) {

        ReferenceCountingGC a=new ReferenceCountingGC();
        ReferenceCountingGC b=new ReferenceCountingGC();

        System.out.println(a==b);
        System.out.println(a.equals(b));

        a.instance=b;
        b.instance=a;

        System.gc();

    }
}
