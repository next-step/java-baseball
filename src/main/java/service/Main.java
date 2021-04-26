package service;

import domain.Bettings;

import java.util.ArrayList;
import java.util.Arrays;

import static service.Game.*;

public class Main {

    static Computer computer = new Computer();

    public static void main(String[] args) {
        init();
        setBettings(computer.setComputerValues());
        Bettings bettings = new Bettings(new ArrayList(Arrays.asList(1,2,3)));
        setBettings(bettings);
        playGame();
        if(!isGameOver()){
            init();
            playGame();
        }
    }
}
