package service;

import domain.Bettings;
import domain.Notice;
import domain.Strike;

public class Game {

    private static UI ui;
    private static Referee referee;
    private static Bettings bettings;

    public static void init(){
        ui = new UI();
        referee = new Referee();
    }

    public static void setBettings(Bettings bettings) {
        Game.bettings = bettings;
    }

    public static void playGame() {
        Strike strike;
        do{
            setUserInputs();
            strike = referee.compareInputsWithValues(bettings);
        } while(!strike.isWin());
    }

    private static void setUserInputs(){
        char[] userInputs = ui
                .getAnswerByNotice(Notice.START_BETTING)
                .toCharArray();
        bettings.setUserInputs(userInputs);
    }

    public static boolean isGameOver() {
        Notice.NOTICE_WIN.print();
        String option = ui.getAnswerByNotice(Notice.ASK_CONTINUE_GAME);
        if("1".equals(option)){
            return true;
        }
        return false;
    }
}
