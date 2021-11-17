package br.mps.business.control;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

import br.mps.business.model.User;
import br.mps.infra.Validator;
import br.mps.view.View;

public class UserController{
    Map<String,String> users;
    View view;

    public UserController(Map<String,String> users, View view){
        this.users = users;
        this.view = view;
    }

    public void createUser(){
        Validator validator;

        Scanner scan = new Scanner(System.in);
        validator = new Validator();

        view.perguntaLogin();
        String login = scan.nextLine();
        
        if(!validator.validaLogin(login)){
            view.loginInvalido();
            return;
        }

        view.perguntaSenha();
        String senha = scan.nextLine();

        if(!validator.validaSenha(senha)){
            view.senhaInvalida();
            return;
        }
          
        users.put(login, new String(senha));


        view.userCriado();
    }

    public void deleteUser(Map<String, String> userList, String name){
        String user = userList.get(name);
        
        if (user != null) {
            userList.remove(name);
            view.userDeletado();
        }
    }

    // public void deleteUser(Map<String, String> userList, String name){
    //     String user = userList.get(name);
        
    //     if (user != null) {
    //         userList.remove(name);
    //         System.out.println("Usuario deletado com sucesso");
    //     }
    // }
}