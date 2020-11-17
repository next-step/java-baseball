package game.ui;

import java.util.Scanner;

public class UtilUserInterface {

    public static int viewUI(String message){
        displayMessage(message);
        Scanner scanner = new Scanner(System.in);

        return requestUserInput(scanner);
    }

    public static void displayMessage(String message){
        System.out.println(message);
    }

    static int requestUserInput(Scanner scanner){
        return scanner.nextInt();
    }
}
