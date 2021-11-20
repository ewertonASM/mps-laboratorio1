package br.mps.business.model;


public class User implements Comparable<User> {
    private String login;
    private String senha;
    private Data data_nascimento;

    public User(String login, String senha, int dia, int mes, int ano){
        super();
        this.login = login;
        this.senha = senha;
        this.data_nascimento = new Data(dia,mes,ano);
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public Data getData(){
        return data_nascimento;
    }
    
    public String getDataNascimento(){
        String data = data_nascimento.getData();
        return data;
    }
    public int compareTo(User user) {
        return login.compareTo(user.login);
    }
} 
