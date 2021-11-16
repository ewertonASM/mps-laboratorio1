package br.mps.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import br.mps.infra.Validator;

import br.mps.business.control.UserController;

public class View{
    public View(){

    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        Map<String,String> users = new HashMap<String,String>();
        UserController controller = new UserController(users, this);

        menu();
        String num = scan.nextLine();
       
        while(true){
            switch (num){
                case "0":
                    System.exit(0);
                case "1":
                    controller.createUser();
                    num = scan.nextLine();
                    break;
                case "2":
                    System.out.print("Lista de usuarios:\n");
                    for (String nome : users.keySet()) { 
                        System.out.print(nome + "\n"); 
                    }
                    num = scan.nextLine();
                    break;
                case "3":
                    System.out.println("Digite o nome do usuário a ser deletado: ");
                    String name = scan.nextLine();
                    controller.deleteUser(users, name);
                    num = scan.nextLine();
                    break;
                default:
                    System.out.println("Comando invalido, tente novamente");
                    menu();
                    num = scan.nextLine();
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para criar um novo usuario");
        System.out.println("Digite 2 para listar os usuarios");
        System.out.println("Digite 3 para deletar um usuario");
    }

    public void perguntaLogin(){
        System.out.println("Digite o login do novo usuario:");
    }

    public void loginInvalido(){
        System.out.println("Login invalido!");
    }

    public void perguntaSenha(){
        System.out.println("Digite a senha do novo usuario:");
    }

    public void senhaInvalida(){
        System.out.println("Senha invalida!");
    }

    public void userCriado(){
        System.out.println("Usuario criado com sucesso");
    }

    public void userDeletado(){
        System.out.println("Usuario deletado com sucesso");
    }
}