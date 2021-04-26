package service;

import domain.*;

import java.util.HashSet;
import java.util.List;

public class Referee {

    private static UI ui;

    private Strike strike;
    private Ball ball;
    private Nothing nothing;

    public Referee() {
        ui = new UI();
    }

    private void createScore(){
        this.strike = new Strike();
        this.ball = new Ball();
        this.nothing = new Nothing();
    }

    public Strike compareInputsWithValues(Bettings bettings) {
        createScore();

        char[] userInputs = bettings.getUserInputs();
        List<Integer> computerValues = bettings.getComputerValues();
        setScore(userInputs, computerValues);

        return strike;
    }

    private void setScore(char[] userInputs, List<Integer> computerValues) {
    }


}
