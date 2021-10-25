package br.mps.business.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.mps.business.model.User;
import br.mps.infra.Validator;

public class UserController{
    Map<String,String> users;

    public UserController(Map<String,String> users){
        this.users = users;
    }

    public void createUser(){
        User newUser;
        Validator validator;

        Scanner scan = new Scanner(System.in);
        validator = new Validator();

        System.out.println("Digite o login do novo usuario:");
        String login = scan.nextLine();

        if(!validator.validaLogin(login)){
            System.out.println("Login invalido!");
            return;
        }

        System.out.println("Digite a senha do novo usuario:");
        String senha = scan.nextLine();

        if(!validator.validaSenha(senha)){
            System.out.println("Senha invalida!");
            return;
        }

        newUser = new User(login, senha);
        users.put(login, new String(senha));

        System.out.println("Usuario criado com sucesso");
    }
}