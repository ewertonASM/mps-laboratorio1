package br.mps.business.model;

public class User implements Comparable<User> {
    private String login;
    private String senha;

    public User(String login, String senha){
        super();
        this.login = login;
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public int compareTo(User user) {
        return login.compareTo(user.login);
    }
} 
