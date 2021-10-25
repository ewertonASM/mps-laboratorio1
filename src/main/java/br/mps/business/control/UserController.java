import java.util.Scanner;

public class UserController{
    public UserController(){
    
    }

    public static void createUser(){
        User newUser;
        Validator validator;

        Scanner scan = new Scanner(System.in);
        validator = new Validator();

        System.out.println("Digite o login do novo usuario:");
        String login = scan.nextLine();

        if(!validator.validaLogin(login)){
            System.out.println("Login invalido!");
            return;
        }

        System.out.println("Digite a senha do novo usuario:");
        String senha = scan.nextLine();

        if(!validator.validaSenha(senha)){
            System.out.println("Senha invalida!");
            return;
        }

        newUser = new User(login, senha);

        System.out.println("Usuario criado com sucesso");
    }
}