package br.mps.business.control;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

import br.mps.business.model.User;
import br.mps.infra.Validator;
import br.mps.view.View;

public class UserController{
    SortedMap<User, Integer> users;
    View view;

    public UserController(SortedMap<User, Integer> users, View view){
        this.users = users;
        this.view = view;
    }

    public void createUser() throws Exception {
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
        
        for (SortedMap.Entry<User, Integer> entry : users.entrySet()) {
            if (entry.getKey().getLogin().equals(login)) {
                Exception error = new Exception("Usuário já existe");
                throw error;
            }
        }

        User user = new User(login, senha);

        users.put(user, users.size());

        view.userCriado();
    }

    public void deleteUser(SortedMap<User, Integer> userList, String name){
        User user = null;

        for (SortedMap.Entry<User, Integer> entry : userList.entrySet()) {
            if (entry.getKey().getLogin().equals(name)) {
                user = entry.getKey();
            }
        }

        if (user != null) {
            userList.remove(user);
            view.userDeletado();
        }
    }
}