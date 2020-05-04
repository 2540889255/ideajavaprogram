package main.com.aynu.test.testoptional;

public class Man {

    private  String name;

    private Godness godness;

    public Man() {
    }

    public Man(String name, Godness godness) {
        this.name = name;
        this.godness = godness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }
}
