package br.mps.infra;

public class Validator{
    public Validator(){

    }

    public boolean validaLogin(String login){
        //login deve ter entre 1 a 12 caracteres
        if(login.length() > 0 && login.length() <= 12){
            if(login.matches(".*\\d.*")){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    public boolean validaSenha(String senha){
        
        //senha entre 8 a 20 caracteres
        if(senha.length() >= 8 && senha.length() <= 20){
            
            //verifica se possui ao menos 2 numeros e letras na senha
            if(senha.matches("^(?=(?:\\D*\\d){2})[a-zA-Z0-9]*$")){
                return true;
            }
            else{
               return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean validaAnoNascimento(int ano){
        if (ano>0){
            return true;
        }
        return false;
    }

    public boolean validaMesNascimento(int mes){
        if (mes>0 && mes<13){
            return true;
        }
        return false;
    }

    public boolean validaDiaNascimento(int dia, int mes){
        
        int qtd_dias_no_mes;
        if ((mes == 1) || (mes == 3)|| (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)){
            qtd_dias_no_mes = 31;
        }else if (mes == 2){
            qtd_dias_no_mes = 29;
        }else{
            qtd_dias_no_mes = 30;
        }
        
        if (mes>0 && mes <= qtd_dias_no_mes){
            return true;
        }
        return false;
    }
}