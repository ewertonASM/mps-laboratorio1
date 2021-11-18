package br.mps.business.control;

import java.util.Scanner;
import java.util.SortedMap;

import br.mps.business.model.User;
import br.mps.infra.Validator;
import br.mps.infra.exceptions.BadRequestException;
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
           throw new BadRequestException("Login Invalido!");
        }

        view.perguntaSenha();
        String senha = scan.nextLine();

        if(!validator.validaSenha(senha)){
           throw new BadRequestException("Senha Invalida!");
        }
        
        for (SortedMap.Entry<User, Integer> entry : users.entrySet()) {
            if (entry.getKey().getLogin().equals(login)) {
                throw new BadRequestException("Login já existe");
            }
        }

        User user = new User(login, senha);

        users.put(user, users.size());

        view.userCriado();
    }

    public void listUsers(){
        for (User user : users.keySet()) {
            System.out.println(user.getLogin());
        }
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