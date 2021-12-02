package br.mps.business.model;


public interface Command {
    void execute();
    void undo();   
}
