package com.aynu.test.designmode;

public interface ComputerBuilder {

    public void setName(String name);

    public void setCpu(String cpu);

    public void setMemory(String memory);

    public void setMonitor(String monitor);

    public void setOs(String os);

    public Computer getResult();
}
