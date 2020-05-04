package main.com.aynu.test.testVM;

public class SaveMyself {

    private static SaveMyself saveMyself;

    public void isalive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法已经运行");
        saveMyself=this;
    }

    public static void main(String[] args) throws InterruptedException {
        saveMyself=new SaveMyself();

        saveMyself=null;
        System.gc();
        Thread.sleep(500);
        if (saveMyself!=null){
            saveMyself.isalive();
        }else {
            System.out.println("我已经死了");
        }

        saveMyself=null;
        System.gc();
        Thread.sleep(500);
        if (saveMyself!=null){
            saveMyself.isalive();
        }else {
            System.out.println("我已经死了");
        }
    }
}
