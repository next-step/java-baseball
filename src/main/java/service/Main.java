package service;

import static service.Game.*;

public class Main {

    static Computer computer = new Computer();

    public static void main(String[] args) {
        init();
        do{
            setBettings(computer.setComputerValues());
            playGame();
        } while(!isGameOver());
        System.exit(0);
    }
}
