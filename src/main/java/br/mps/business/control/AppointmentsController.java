package br.mps.business.control;

import java.time.LocalDate;
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

    public void createAppointment(String userName, String appointmentName, LocalDate date){
        
        for(Appointment appointment : appointments){
            if(date.isEqual(appointment.getDate())){
                view.dateUnavaliable();
                return;
            }
        }
       
        Appointment appointment = new Appointment(appointments.size() + 1, userName, appointmentName, date);
        
        appointments.add(appointment);

        view.appointmentCreated();
    }

    public void listAppointments(){
        for(Appointment appointment : appointments){
            view.printAppointment(appointment);
        }
    }

    public void updateAppointment(LocalDate oldDate, LocalDate newDate){
        for(Appointment appointment : appointments){
            if(oldDate.isEqual(appointment.getDate())){
                appointment.changeDate(newDate);
            }
        }
    }

    public void deleteAppointment(LocalDate date){

        for(Appointment appointment : appointments){
            if(date.isEqual(appointment.getDate())){
                appointments.remove(appointment);
                view.appointmentDeleted();
                return;
            }
        }

        view.appointmentNotFound();
    }
}
