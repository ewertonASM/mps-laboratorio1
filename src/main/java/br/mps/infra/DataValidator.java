package br.mps.infra;

public class DataValidator{
    public DataValidator(){
        
    }

    public boolean validaData(int dia, int mes, int ano){
        if(ano < 0 || mes < 0 || mes > 12){
            return false;
        }
        else if(!validaDia(dia, mes)){
            return false;
        }
        else{
            return true;
        }
    }


    public boolean validaDia(int dia, int mes){
        
        int qtd_dias_no_mes;
        if ((mes == 1) || (mes == 3)|| (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
            qtd_dias_no_mes = 31;
        }else if (mes == 2){
            qtd_dias_no_mes = 29;
        }else{
            qtd_dias_no_mes = 30;
        }
        
        if (mes>0 && dia <= qtd_dias_no_mes){
            return true;
        }
        return false;
    }
}
