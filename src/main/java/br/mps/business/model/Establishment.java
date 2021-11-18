package br.mps.business.model;

public class Establishment {
    String name;
    String owner;

    public Establishment(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

   public String getName(){
       return name;
   }

   public String getOwner(){
       return owner;
   }

   public void updateName(String newName){
       this.name = newName;
   }
}
