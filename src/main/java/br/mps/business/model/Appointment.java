package br.mps.business.model;

import java.util.Date;

public class Appointment {
    int id;
    String userName;
    String appointmentName;
    Date date;

    public Appointment(int id, String userName, String appointmentName, Date date){
        this.id = id;
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

    public Date getDate(){
        return date;
    }
}
