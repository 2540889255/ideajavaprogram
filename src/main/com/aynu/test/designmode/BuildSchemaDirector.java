package main.com.aynu.test.designmode;

public class BuildSchemaDirector {

    ComputerBuilder computerBuilder;

    public ThinkPadComputer thinkPadComputerConstruct(){
        computerBuilder=new ThinkPadComputerBuilder();
        computerBuilder.setCpu("i7-9750h");
        computerBuilder.setMemory("8G");
        computerBuilder.setMonitor("17寸显示屏");
        computerBuilder.setName("联想");
        computerBuilder.setOs("windows");
        return (ThinkPadComputer) computerBuilder.getResult();
    }

    public MacheNikeComputer macheNikeComputerConstruct(){
        computerBuilder=new MacheNikeComputerBuilder();
        computerBuilder.setCpu("i7-9950h");
        computerBuilder.setMemory("16G");
        computerBuilder.setMonitor("19寸显示屏");
        computerBuilder.setName("机械师");
        computerBuilder.setOs("linux");
        return (MacheNikeComputer) computerBuilder.getResult();
    }

    public static void main(String[] args) {
        BuildSchemaDirector buildSchemaDirector=new BuildSchemaDirector();
        MacheNikeComputer macheNikeComputer = buildSchemaDirector.macheNikeComputerConstruct();
        System.out.println(macheNikeComputer);
        ThinkPadComputer thinkPadComputer = buildSchemaDirector.thinkPadComputerConstruct();
        System.out.println(thinkPadComputer);


    }
}
