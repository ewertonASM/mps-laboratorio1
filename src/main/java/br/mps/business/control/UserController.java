package br.mps.business.control;

import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.Collections;
import java.util.TreeSet;

import br.mps.business.model.User;
import br.mps.infra.Validator;
import br.mps.infra.exceptions.BadRequestException;
import br.mps.view.View;
import br.mps.business.model.ComparadorData;
import br.mps.business.model.Data;

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

        view.perguntaAnoNascimento();
        int ano = Integer.parseInt(scan.nextLine());

        if(!validator.validaAnoNascimento(ano)){
            throw new BadRequestException("Ano Invalido!");
         }

        view.perguntaMesNascimento();
        int mes = Integer.parseInt(scan.nextLine());

        if(!validator.validaMesNascimento(mes)){
            throw new BadRequestException("Mes Invalido!");
         }

        view.perguntaDiaNascimento();
        int dia = Integer.parseInt(scan.nextLine());

        if(!validator.validaDiaNascimento(dia,mes)){
            throw new BadRequestException("Dia Invalido!");
         }

        User user = new User(login, senha, dia, mes, ano);

        users.add(user);

        view.userCriado();
    }

    public void listUsers(){
        for (User user : users) {
            System.out.println(user.getLogin());
        }
    }

    public void listUsersData(){
        Set<User> test_data = new TreeSet<User>(new ComparadorData());
        
        for (User user : users) {
            test_data.add(user);
        }

        String data_string = "";
        for (User user : test_data) {
            System.out.print(user.getLogin());
            data_string = user.getDataNascimento();
            System.out.println(data_string);
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