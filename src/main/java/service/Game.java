package service;

import domain.Bettings;
import domain.Notice;

public class Game {

    private static UI ui;
    private static Bettings bettings;

    private static void setUserInputs(){
        char[] userInputs = ui
                .getAnswerByNotice(Notice.START_BETTING)
                .toCharArray();
        bettings.setUserInputs(userInputs);
    }
}
