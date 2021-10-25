package br.mps.business.model;

public class User{
    private String login;
    private String senha;

    public User(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }
} 
