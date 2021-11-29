package Views;

import controller.ViewController;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Cli {

    public static void main(String[] args) throws IOException {
        ViewController vc = new ViewController();
        Scanner inputUser = new Scanner(System.in);
        Scanner inputPasswd = new Scanner(System.in);
        Console console = System.console();
        Scanner inputId = new Scanner(System.in);
        String user, password, idMachine;

        
        System.out.println("      ___           ___           ___       ___           ___           ___           ___                       ___     \n" +
"     /\\  \\         /\\__\\         /\\__\\     /\\  \\         /\\  \\         /\\  \\         /\\  \\          ___        |\\__\\    \n" +
"    /::\\  \\       /:/  /        /:/  /    /::\\  \\       /::\\  \\        \\:\\  \\       /::\\  \\        /\\  \\       |:|  |   \n" +
"   /:/\\:\\  \\     /:/  /        /:/  /    /:/\\ \\  \\     /:/\\:\\  \\        \\:\\  \\     /:/\\:\\  \\       \\:\\  \\      |:|  |   \n" +
"  /::\\~\\:\\  \\   /:/  /  ___   /:/  /    _\\:\\~\\ \\  \\   /::\\~\\:\\  \\       /::\\  \\   /::\\~\\:\\  \\      /::\\__\\     |:|__|__ \n" +
" /:/\\:\\ \\:\\__\\ /:/__/  /\\__\\ /:/__/    /\\ \\:\\ \\ \\__\\ /:/\\:\\ \\:\\__\\     /:/\\:\\__\\ /:/\\:\\ \\:\\__\\  __/:/\\/__/ ____/::::\\__\\\n" +
" \\/__\\:\\/:/  / \\:\\  \\ /:/  / \\:\\  \\    \\:\\ \\:\\ \\/__/ \\/__\\:\\/:/  /    /:/  \\/__/ \\/_|::\\/:/  / /\\/:/  /    \\::::/~~/~   \n" +
"      \\::/  /   \\:\\  /:/  /   \\:\\  \\    \\:\\ \\:\\__\\        \\::/  /    /:/  /         |:|::/  /  \\::/__/      ~~|:|~~|    \n" +
"       \\/__/     \\:\\/:/  /     \\:\\  \\    \\:\\/:/  /        /:/  /     \\/__/          |:|\\/__/    \\:\\__\\        |:|  |    \n" +
"                  \\::/  /       \\:\\__\\    \\::/  /        /:/  /                     |:|  |       \\/__/        |:|  |    \n" +
"                   \\/__/         \\/__/     \\/__/         \\/__/                       \\|__|                     \\|__|    ");

        System.out.println("\nDigite seu usuario: ");
        user = inputUser.nextLine();

        //System.out.println("Digite sua senha: ");
        //password = inputPasswd.nextLine();
        password = new String(console.readPassword("Digite sua senha: "));

        System.out.println("Digite o id da maquina: ");

        idMachine = inputId.nextLine();

        vc.init();

        Boolean result = vc.verifyUserAndMachine(user, password, idMachine);
        System.out.println(result);
        if (result) {
            Boolean checkFirstTime = vc.calibratePc(false, idMachine);

            if (checkFirstTime) {
                vc.start();
            }

        } else {
            System.out.println("Erro ao verificar a m�quina, por favor tente novamente!");

        }
    };
}