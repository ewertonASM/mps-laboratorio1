package br.mps.business.control;

import java.util.Date;
import java.util.ArrayList;
import br.mps.view.View;
import br.mps.business.model.Appointment;

public class AppointmentsController {
    ArrayList<Appointment> appointments;
    View view;

    public AppointmentsController(ArrayList<Appointment> appointments, View view){
        this.appointments = appointments;
        this.view = view;
    }

    public void createAppointment(String userName, String appointmentName, Date date){
        
        for(Appointment appointment : appointments){
            if(date == appointment.getDate()){
                view.dateUnavaliable();
                return;
            }
        }
       
        Appointment appointment = new Appointment(appointments.size() + 1, userName, appointmentName, date);
        
        appointments.add(appointment);

        view.appointmentCreated();
    }

    public void deleteAppointment(Date date){

        for(Appointment appointment : appointments){
            if(date == appointment.getDate()){
                appointments.remove(appointment);
                view.appointmentDeleted();
                return;
            }
        }

        view.appointmentNotFound();
    }
}
