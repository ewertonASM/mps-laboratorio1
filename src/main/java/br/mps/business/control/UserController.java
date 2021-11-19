package br.mps.business.control;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;

import br.mps.business.model.User;
import br.mps.infra.Validator;
import br.mps.infra.exceptions.BadRequestException;
import br.mps.view.View;

public class UserController{
    Set<User> users;
    View view;

    public UserController(Set<User> users, View view){
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
        
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                throw new BadRequestException("Login já existe");
            }
        }

        User user = new User(login, senha);

        users.add(user);

        view.userCriado();
    }

    public void listUsers(){
        for (User user : users) {
            System.out.println(user.getLogin());
        }
    }

    public void deleteUser(Set<User> userList, String name){
        User user = null;

        for (User userIter : users) {
            if (userIter.getLogin().equals(name)) {
                user = userIter;
            }
        }

        if (user != null) {
            userList.remove(user);
            view.userDeletado();
        }
    }
}