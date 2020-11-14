package jito.baseball.util;

import jito.baseball.message.GameMessage;

public class UserInterfaceUtils {

    public static void startMessage() {
        System.out.print(GameMessage.START);
    }

    public static void successMessage() {
        System.out.println(GameMessage.SUCCESS);
    }

    public static void endMessage() {
        System.out.println(GameMessage.END);
    }

    public static void restartMessage() {
        System.out.println(GameMessage.RESTART);
    }

    public static void printMessage(String string) {
        System.out.println(string);
    }

}
