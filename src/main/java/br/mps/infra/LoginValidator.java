package br.mps.infra;

public class LoginValidator {
    public LoginValidator(){

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
}