package br.mps.infra;

public class ValidatorController implements Validator{
    public ValidatorController(){

    }

    public boolean validateString(int type, String string){
        LoginValidator loginValidator = new LoginValidator();

        switch(type){
            case 1:
                return loginValidator.validaLogin(string);
            case 2:
                return loginValidator.validaSenha(string);
        }

        return false;
    }

    public boolean validateInt(int dia, int mes, int ano){
        DataValidator dataValidator = new DataValidator();

        return dataValidator.validaData(dia, mes, ano);
    }
}
