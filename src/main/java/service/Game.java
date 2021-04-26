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
    
    public static boolean isGameOver() {
        Notice.NOTICE_WIN.print();
        String option = ui.getAnswerByNotice(Notice.ASK_CONTINUE_GAME);
        if("1".equals(option)){
            return true;
        }
        return false;
    }
}
