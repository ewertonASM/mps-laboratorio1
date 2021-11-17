package br.mps.business.model;

import java.time.LocalDate;

public class Appointment {
    int id;
    String userName;
    String appointmentName;
    LocalDate date;

    public Appointment(int id, String userName, String appointmentName, LocalDate date){
        this.id = id;
        this.userName = userName;
        this.appointmentName = appointmentName;
        this.date = date;
    }

    public int getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public String getAppointmentName(){
        return appointmentName;
    }

    public LocalDate getDate(){
        return date;
    }

    public void changeDate(LocalDate date){
        this.date = date;
    }
}
