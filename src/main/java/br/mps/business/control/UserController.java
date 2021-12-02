package br.mps.business.control;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import br.mps.business.model.User;
import br.mps.infra.DataValidator;
import br.mps.infra.LoginValidator;
import br.mps.infra.Validator;
import br.mps.infra.ValidatorController;
import br.mps.infra.exceptions.BadRequestException;
import br.mps.view.View;
import br.mps.business.model.ComparadorData;
import br.mps.business.model.ListUsersDate;

public class UserController{
    Set<User> users;
    View view;

    public UserController(Set<User> users, View view){

        this.users = users;
        this.view = view;
    }

    public void createUser() throws Exception {

        Validator validator = new ValidatorController();

        Scanner scan = new Scanner(System.in);

        view.perguntaLogin();
        String login = scan.nextLine();
        
        if(!validator.validateString(1, login)){
           throw new BadRequestException("Login Invalido!");
        }

        view.perguntaSenha();
        String senha = scan.nextLine();

        if(!validator.validateString(2, senha)){
           throw new BadRequestException("Senha Invalida!");
        }
        
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                throw new BadRequestException("Login já existe");
            }
        }

        view.perguntaAnoNascimento();
        int ano = Integer.parseInt(scan.nextLine());

        view.perguntaMesNascimento();
        int mes = Integer.parseInt(scan.nextLine());

        view.perguntaDiaNascimento();
        int dia = Integer.parseInt(scan.nextLine());

        if(!validator.validateInt(dia, mes, ano)){
            throw new BadRequestException("Data Invalida!");
         }

        User user = new User(login, senha, dia, mes, ano);

        users.add(user);

        view.userCriado();
    }

    public void listUsers(){
        ListUsersController listUsersController = new ListUsersController(null, users);
        
        listUsersController.listUsersName(users);
    }

    public void listUsersData(){
        ListUsersDate listUsersDate = new ListUsersDate();
        
        ListUsersController listUsersController = new ListUsersController(listUsersDate, users);
        
        listUsersController.listUsersByDate();
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
        } else{
            throw new BadRequestException("Usuario nao encontrado!");
        }
    }

    public void restaurarUsuarios(Set<User> users){
        this.users = users;
        System.out.println("Usuários restaurados com sucesso");
    }

    public Set<User> getUsers(){
        return users;
    }
}