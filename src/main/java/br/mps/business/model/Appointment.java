package br.mps.business.model;

import java.time.LocalDate;

public class Appointment {
    String userName;
    String appointmentName;
    LocalDate date;

    public Appointment(String userName, String appointmentName, LocalDate date){
        this.userName = userName;
        this.appointmentName = appointmentName;
        this.date = date;
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
