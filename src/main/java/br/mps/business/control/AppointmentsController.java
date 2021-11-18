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
            if(checkDate(date, appointment.getDate())){
                view.dateUnavaliable();
                return;
            }
        }
       
        Appointment appointment = new Appointment(userName, appointmentName, date);
        
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
            if(checkDate(oldDate, appointment.getDate())){
                appointment.changeDate(newDate);
            }
        }
    }

    public void deleteAppointment(LocalDate date){

        for(Appointment appointment : appointments){
            if(checkDate(date, appointment.getDate())){
                appointments.remove(appointment);
                view.appointmentDeleted();
                return;
            }
        }

        view.appointmentNotFound();
    }

    private boolean checkDate(LocalDate date1, LocalDate date2){
        if(date1.isEqual(date2)){
            return true;
        } else{
            return false;
        }
    }
}
