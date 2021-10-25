package br.mps.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.mps.business.control.UserController;

public class View{
    public View(){

    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        Map<String,String> users = new HashMap<String,String>();
        UserController controller = new UserController(users);

        System.out.println("Digite 1 para criar um novo usuario");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 3 para deletar um usuario");

        String num = scan.nextLine();
        
        while(true){
            switch (num){
                case "0":
                    System.exit(0);
                case "1":
                    controller.createUser();
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
                    num = scan.nextLine();
                    break;
            }
        }
    }
}