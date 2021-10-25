import java.util.Scanner;

public class View{
    public View(){

    }

    public void run(){
        Scanner scan = new Scanner(System.in);
        UserController controller = new UserController();

        System.out.println("Digite 1 para criar um novo usuario");
        System.out.println("Digite 0 para sair");
        String num = scan.nextLine();
        
        while(true){
            switch (num){
                case "0":
                    System.exit(0);
                case "1":
                    controller.createUser();
                    num = scan.nextLine();
                    break;
                default:
                    System.out.println("Comando invalido, tente novamente");
                    num = scan.nextLine();
                    break;
            }
        }
    }
}