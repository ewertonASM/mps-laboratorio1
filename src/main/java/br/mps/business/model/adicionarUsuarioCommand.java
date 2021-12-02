package br.mps.business.model;
import java.util.Set;
import java.util.TreeSet;

import br.mps.business.control.SingletonFacade;


public class adicionarUsuarioCommand implements Command{
    SingletonFacade singletonFacade;
    Set<User> users;
    

    public adicionarUsuarioCommand(SingletonFacade singletonFacade){
        this.singletonFacade = singletonFacade;
        this.users = new TreeSet<User>();
        this.users.addAll(this.singletonFacade.getUsers());   
    }

    @Override
    public void execute() {
        singletonFacade.createUser();   
    }

    @Override
    public void undo(){
        singletonFacade.restaurarUsuarios(users);
    
    }
} 
