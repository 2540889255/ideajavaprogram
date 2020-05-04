package main.com.aynu.test.designmode;

public class MacheNikeComputerBuilder implements ComputerBuilder {

    private MacheNikeComputer macheNikeComputer=new MacheNikeComputer();

    @Override
    public void setName(String name) {
        this.macheNikeComputer.setName(name);
    }

    @Override
    public void setCpu(String cpu) {
        this.macheNikeComputer.setCpu(cpu);
    }

    @Override
    public void setMemory(String memory) {
        this.macheNikeComputer.setMemory(memory);
    }

    @Override
    public void setMonitor(String monitor) {
        this.macheNikeComputer.setMonitor(monitor);
    }

    @Override
    public void setOs(String os) {
        this.macheNikeComputer.setOs(os);
    }

    @Override
    public Computer getResult() {
        return this.macheNikeComputer;
    }
}
