package com.aynu.test.designmode;

public abstract class Computer {

    private String name;//名字

    private String cpu;//cpu

    private String type;//型号

    private String memory;// 内存

    private String monitor;//监视器 显示屏

    private String os;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", type='" + type + '\'' +
                ", memory='" + memory + '\'' +
                ", monitor='" + monitor + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
