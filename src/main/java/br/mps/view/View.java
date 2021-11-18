package br.mps.view;

import java.util.Scanner;

import java.time.LocalDate;

import br.mps.business.control.SingletonFacade;
import br.mps.business.model.Appointment;
import br.mps.business.model.Establishment;

public class View{
    public View(){

    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        
        SingletonFacade singletonFacade = new SingletonFacade(this);
        
        menu();
        String num = scan.nextLine();
       
        while(true){
            switch (num){
                case "0":
                    System.exit(0);
                case "1":
                    singletonFacade.createUser();
                    num = scan.nextLine();
                    break;
                case "2":
                    System.out.print("Lista de usuarios:\n");
                    singletonFacade.listUsers();
                    num = scan.nextLine();
                    break;
                case "3":
                    System.out.println("Digite o nome do usuário a ser deletado: ");
                    String name = scan.nextLine();
                    singletonFacade.deleteUser(name);
                    num = scan.nextLine();
                    break;
                case "4":
                    criarAgendamento(singletonFacade, scan);
                    num = scan.nextLine();
                    break;
                case "5":
                    singletonFacade.listAppointments();
                    num = scan.nextLine();
                    break;
                case "6":
                    System.out.println("Digite a data do agendamento que deseja alterar");
                    LocalDate oldDate = perguntaData(scan);
                    System.out.println("Digite a nova data do agendamento");
                    LocalDate newDate = perguntaData(scan);
                    singletonFacade.updateAppointment(oldDate, newDate);
                    num = scan.nextLine();
                    break;
                case "7":
                    System.out.println("Digite a data que deseja excluir o agendamento");
                    LocalDate date = perguntaData(scan);
                    singletonFacade.deleteAppointment(date);
                    num = scan.nextLine();
                    break;
                case "8":
                    cadastrarEstabelecimento(singletonFacade, scan);
                    num = scan.nextLine();
                    break;
                case "9":
                    singletonFacade.listEstablishments();
                    num = scan.nextLine();
                    break;
                case "10":
                    atualizaNome(singletonFacade, scan);
                    num = scan.nextLine();
                    break;
                case "11":
                    System.out.println("Digite o nome do estabelecimento que voce deseja deletar");
                    String n = scan.nextLine();
                    singletonFacade.deleteEstablishment(n);
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
        System.out.println("Digite 7 para deletar o agendamento");
        System.out.println("Digite 8 para cadastrar um estabelecimento");
        System.out.println("Digite 9 para listar os estabelecimentos");
        System.out.println("Digite 10 para alterar o nome de um estabelecimento");
        System.out.println("Digite 11 para deletar um estabelecimento");
    }

    public void criarAgendamento(SingletonFacade singletonFacade, Scanner scan){

        System.out.println("Digite o nome do usuario que quer criar o agendamento");
        String name = scan.nextLine();

        System.out.println("Digite o nome do agendamento");
        String appointmentName = scan.nextLine();

        LocalDate date = perguntaData(scan);

        singletonFacade.createAppointment(name, appointmentName, date);
    }

    public void cadastrarEstabelecimento(SingletonFacade singletonFacade, Scanner scan){

        System.out.println("Digite o nome do estabelecimento");
        String name = scan.nextLine();

        System.out.println("Digite o nome do dono do estabelecimento");
        String owner = scan.nextLine();

        singletonFacade.createEstablishment(name, owner);
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

    public void atualizaNome(SingletonFacade singletonFacade, Scanner scan){
        System.out.println("Digite o nome atual do estabelecimento");
        String oldName = scan.nextLine();
        
        System.out.println("Digite o novo nome do estabelecimento");
        String newName = scan.nextLine();

        singletonFacade.changeName(oldName, newName);
    }

    public void printAppointment(Appointment appointment){
        System.out.println("Nome do usuario:" + appointment.getUserName());
        System.out.println("Nome do agendamento:" + appointment.getAppointmentName());
        System.out.println("Data do agendamento:" + appointment.getDate());
        System.out.println("//////////////////////////////////////////////////////////");
    }

    public void printEstablishment(Establishment establishment){
        System.out.println("Nome do estabelecimento: " + establishment.getName());
        System.out.println("Dono do estabelecimento: " + establishment.getOwner());
        System.out.println("//////////////////////////////////////////////////////////");
    }

    public void perguntaLogin(){
        System.out.println("Digite o login do novo usuario:");
    }

    public void perguntaSenha(){
        System.out.println("Digite a senha do novo usuario:");
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

    public void appointmentDeleted(){
        System.out.println("Agendamento deletado com sucesso");
    }

    public void establishmentCreated(){
        System.out.println("Estabelecimento criado com sucesso");
    }

    public void establishmentNameUpdated(){
        System.out.println("Nome atualizado com sucesso");
    }

    public void establishmentDeleted(){
        System.out.println("Estabelecimento deletado com sucesso");
    }
}