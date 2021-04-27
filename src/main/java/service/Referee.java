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

    public Strike manageScore(Bettings bettings) {
        createScore();

        char[] userInputs = bettings.getUserInputs();
        List<Integer> computerValues = bettings.getComputerValues();
        setScore(userInputs, computerValues);

        ui.printScore(strike,ball,nothing);

        return strike;
    }

    private void setScore(char[] userInputs, List<Integer> computerValues) {
        HashSet set = new HashSet();

        for (int i = 0; i < userInputs.length; i++) {
            int userInput = userInputs[i]-'0';
            addScore(userInput, computerValues.get(i), strike);
            set.add(userInput);
            set.add(computerValues.get(i));
        }

        int ballCount = ((Bettings.bettingSize()*2) - set.size()) - strike.getCount();
        ball.setCount(ballCount);
    }

    private void addScore(int betting, int number, Score score){
        if(betting == number){
            score.addOneToCount();
        }
    }
}
