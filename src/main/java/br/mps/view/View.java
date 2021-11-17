package br.mps.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import br.mps.business.control.UserController;
import br.mps.business.control.AppointmentsController;
import br.mps.business.model.Appointment;

public class View{
    public View(){

    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        Map<String,String> users = new HashMap<String,String>();
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();

        UserController controller = new UserController(users, this);
        AppointmentsController aptController = new AppointmentsController(appointments, this);
        
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
                case "4":
                    System.out.println("Criar agendamento:");
                    criarAgendamento();
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
        System.out.println("Digite 4 para criar novo agendamento");
    }

    public void criarAgendamento(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do usuario que quer criar o agendamento");
        String name = scan.nextLine();

        System.out.println("Digite o nome do agendamento");
        String appointmentName = scan.nextLine();

        System.out.println("Digite o dia do agendamento");
        String day = scan.nextLine();

        System.out.println("Digite o mes do agendamento");
        String month = scan.nextLine();

        System.out.println("Digite o ano do agendamento");
        String year = scan.nextLine();

        LocalDate date = LocalDate.parse(year + "-" + month + "-" + day);

        
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

    public void appointmentCreated(){
        System.out.println("Agendamento realizado com sucesso");
    }

    public void appointmentNotFound(){
        System.out.println("Agendamento nao encontrado");
    }

    public void appointmentDeleted(){
        System.out.println("Agendamento deletado");
    }

    public void dateUnavaliable(){
        System.out.println("Horario indisponivel");
    }
}