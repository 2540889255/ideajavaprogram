package main.com.aynu.test.testoptional;

import java.util.Optional;

public class NewMan {

    private Optional<Godness> godness=Optional.empty();

    private String name;

    public NewMan() {
    }

    public NewMan(String name) {
        this.name = name;
    }

    public NewMan(Optional<Godness> godness, String name) {
        this.godness = godness;
        this.name = name;
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
