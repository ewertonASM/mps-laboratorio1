package br.mps.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
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
                    criarAgendamento(aptController);
                    num = scan.nextLine();
                    break;
                case "5":
                    aptController.listAppointments();
                    num = scan.nextLine();
                    break;
                case "6":
                    System.out.println("Digite a data do agendamento que deseja alterar");
                    LocalDate oldDate = perguntaData(scan);
                    System.out.println("Digite a nova data do agendamento");
                    LocalDate newDate = perguntaData(scan);
                    aptController.updateAppointment(oldDate, newDate);
                    num = scan.nextLine();
                    break;
                case "7":
                    System.out.println("Digite a data que deseja excluir o agendamento");
                    LocalDate date = perguntaData(scan);
                    aptController.deleteAppointment(date);
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
        System.out.println("Digite 4 para criar novo agendamento");
        System.out.println("Digite 5 para listar agendamentos");
        System.out.println("Digite 6 para alterar a data de um agendamento");
        System.out.println("Digite 7 para deletar um agendamento");
    }

    public void criarAgendamento(AppointmentsController aptController){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do usuario que quer criar o agendamento");
        String name = scan.nextLine();

        System.out.println("Digite o nome do agendamento");
        String appointmentName = scan.nextLine();

        LocalDate date = perguntaData(scan);

        aptController.createAppointment(name, appointmentName, date);
    }

    public LocalDate perguntaData(Scanner scan){
        System.out.println("Digite o dia do agendamento");
        String day = scan.nextLine();

        System.out.println("Digite o mes do agendamento");
        String month = scan.nextLine();

        System.out.println("Digite o ano do agendamento");
        String year = scan.nextLine();

        LocalDate date = LocalDate.parse(year + "-" + month + "-" + day);

        return date;
    }

    public void printAppointment(Appointment appointment){
        System.out.println("Id:" + appointment.getId());
        System.out.println("Nome do usuario:" + appointment.getUserName());
        System.out.println("Nome do agendamento:" + appointment.getAppointmentName());
        System.out.println("Data do agendamento:" + appointment.getDate());
        System.out.println("//////////////////////////////////////////////////////////");
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