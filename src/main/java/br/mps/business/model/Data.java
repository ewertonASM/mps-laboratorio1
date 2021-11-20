package br.mps.business.model;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        super();
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
       
    }

    public String getData(){
        String data = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(ano);
        return data;
    }
    
    public int getAno(){
        return ano;
    }

    public int getMes(){
        return mes;
    }
    public int getDia(){
        return dia;
    }


} 
