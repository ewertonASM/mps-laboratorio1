package br.mps.business.control;

import java.util.ArrayList;

import br.mps.view.View;
import br.mps.business.model.Establishment;
import br.mps.infra.exceptions.BadRequestException;

public class EstablishmentController {
    ArrayList<Establishment> establishments;
    View view;

    public EstablishmentController(ArrayList<Establishment> establishments, View view){
        this.establishments = establishments;
        this.view = view;
    }

    public void createEstablishment(String name, String owner){
        Establishment establishment = new Establishment(name, owner);

        establishments.add(establishment);

        view.establishmentCreated();
    }

    public void listEstablishments(){
        for(Establishment establishment : establishments){
            view.printEstablishment(establishment);
        }
    }

    public void changeName(String oldName, String newName){   
        for(Establishment establishment : establishments){
            if(checkName(oldName, establishment.getName())){
                establishment.updateName(newName);
                view.establishmentNameUpdated();
                return;
            }
        }

        throw new BadRequestException("Estabelecimento nao encontrado");
    }

    public void deleteEstablishment(String name){
        for(Establishment establishment : establishments){
            if(checkName(name, establishment.getName())){
                establishments.remove(establishment);
                view.establishmentDeleted();
                return;
            }
        }

        throw new BadRequestException("Estabelecimento nao encontrado");
    }

    private boolean checkName(String name1, String name2){
        if(name1.equals(name2)){
            return true;
        } else{
            return false;
        }
    }
}
