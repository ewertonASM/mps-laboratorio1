package br.mps.infra;

public interface Validator{
    public boolean validateString(int type, String string);
    public boolean validateInt(int dia, int mes, int ano);
}
