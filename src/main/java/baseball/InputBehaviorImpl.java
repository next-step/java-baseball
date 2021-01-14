package baseball;

import java.util.Scanner;

public class InputBehaviorImpl implements InputBehavior {
    private static final String CONTINUE_GAME_CONDITION = "1";
    Scanner scanner = new Scanner(System.in);

    @Override
    public String inputOneInnings() {
        return scanner.next();
    }

    @Override
    public boolean inputIsContinueGame(InningsResult inningsResult) {
        if (inningsResult.isEndMatch()) {
            return scanner.next().equals(CONTINUE_GAME_CONDITION);
        } else {
            return true;
        }

    }
}
