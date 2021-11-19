package br.mps.business.control;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import br.mps.view.View;
import br.mps.business.control.UserController;
import br.mps.business.control.AppointmentsController;
import br.mps.business.control.EstablishmentController;
import br.mps.business.model.User;
import br.mps.business.model.Appointment;
import br.mps.business.model.Establishment;

public class SingletonFacade {
    View view;

    UserController userController;
    AppointmentsController aptController;
    EstablishmentController estController;

    Set<User> users;
    ArrayList<Appointment> appointments;
    ArrayList<Establishment> establishments;

    public SingletonFacade(View view){
        this.view = view;
        this.users = new TreeSet<User>();
        this.appointments = new ArrayList<Appointment>();
        this.establishments = new ArrayList<Establishment>();

        this.userController = new UserController(users, view);
        this.aptController = new AppointmentsController(appointments, view);
        this.estController = new EstablishmentController(establishments, view);

    }

    public void createUser(){
        try {
            userController.createUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listUsers(){
        userController.listUsers();
    }

    public void deleteUser(String name){
        userController.deleteUser(users, name);
    }

    public void createAppointment(String name, String appointmentName, LocalDate date){
        aptController.createAppointment(name, appointmentName, date);
    }

    public void listAppointments(){
        aptController.listAppointments();
    }

    public void updateAppointment(LocalDate oldDate, LocalDate newDate){
        aptController.updateAppointment(oldDate, newDate);
    }

    public void deleteAppointment(LocalDate date){
        aptController.deleteAppointment(date);
    }

    public void createEstablishment(String name, String owner){
        estController.createEstablishment(name, owner);
    }

    public void listEstablishments(){
        estController.listEstablishments();
    }

    public void changeName(String oldName, String newName){
        estController.changeName(oldName, newName);
    }

    public void deleteEstablishment(String name){
        estController.deleteEstablishment(name);
    }
}
