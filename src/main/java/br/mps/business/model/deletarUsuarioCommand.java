package br.mps.business.model;
import java.util.Set;
import java.util.TreeSet;

import br.mps.business.control.SingletonFacade;


public class deletarUsuarioCommand implements Command{
    SingletonFacade singletonFacade;
    Set<User> users;
    String name;
    public deletarUsuarioCommand(SingletonFacade singletonFacade, String name){
        this.singletonFacade = singletonFacade;
        this.name = name;
        this.users = new TreeSet<User>();
        this.users.addAll(this.singletonFacade.getUsers());
    }

    @Override
    public void execute() {
        singletonFacade.deleteUser(name);
    }

    @Override
    public void undo(){
        singletonFacade.restaurarUsuarios(users);   
    }
} 
