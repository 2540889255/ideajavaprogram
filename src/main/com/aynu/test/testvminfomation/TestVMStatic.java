package main.com.aynu.test.testvminfomation;

/**
 * 这个是测试 vm client  静态父类的静态语句块 优先于  子类的静态语句块
 */
public  class TestVMStatic {
    static  int C=1;

    static {
        C=2;
    }

    static class TestVMSOn extends TestVMStatic{
        public  static int D=C;
    }


    static class Father {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B=A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
        System.out.println(TestVMSOn.D);
    }
}
