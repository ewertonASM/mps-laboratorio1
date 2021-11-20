package br.mps.business.model;

import java.util.Comparator;


public class ComparadorData implements Comparator<User>{
    @Override
    public int compare(User user1, User user2){

        Data dataUser1 = user1.getData();
        Data dataUser2 = user2.getData();

        int u1Ano = dataUser1.getAno();
        int u2Ano = dataUser2.getAno();

        if (u1Ano != u2Ano){
            if (u1Ano > u2Ano){
                return -1;
            }
                return 1;
        }

        int u1Mes = dataUser1.getMes();
        int u2Mes = dataUser2.getMes();

        if (u1Mes != u2Mes){
            if (u1Mes > u2Mes){
                return -1;
            }
                return 1;
        }

        int u1Dia = dataUser1.getDia();
        int u2Dia = dataUser2.getDia();
        
        if (u1Dia > u2Dia){
            return -1;
        }
            return 1;
        
        
    }
}


