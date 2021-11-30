package br.mps.business.model;

import br.mps.business.control.memento.Momento;
import br.mps.business.control.memento.Originator;

public class Establishment {
    String name;
    String owner;

    public Establishment(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public Momento save() {
        return new Originator(this.name);
    }

    public void restore(Momento momento) {
        this.name = momento.getName();
    }
}
