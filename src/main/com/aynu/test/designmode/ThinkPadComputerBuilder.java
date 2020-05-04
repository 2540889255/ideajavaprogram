package main.com.aynu.test.designmode;

public class ThinkPadComputerBuilder implements ComputerBuilder {

    private ThinkPadComputer thinkPadComputer=new ThinkPadComputer();

    @Override
    public void setName(String name) {
        this.thinkPadComputer.setName(name);
    }

    @Override
    public void setCpu(String cpu) {
        this.thinkPadComputer.setCpu(cpu);
    }

    @Override
    public void setMemory(String memory) {
        this.thinkPadComputer.setMemory(memory);
    }

    @Override
    public void setMonitor(String monitor) {
        this.thinkPadComputer.setMonitor(monitor);
    }

    @Override
    public void setOs(String os) {
        this.thinkPadComputer.setOs(os);
    }

    @Override
    public Computer getResult() {
        return this.thinkPadComputer;
    }
}
