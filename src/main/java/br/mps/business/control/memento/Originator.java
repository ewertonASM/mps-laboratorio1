package br.mps.business.control.memento;

public class Originator implements Momento {
    private String name;

    public Originator(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
