package baseball;

import java.util.Scanner;

public class GameCore {

    /*
        게임 커멘드.
     */
    public static boolean processor() {
        BaseballUtil.outMessageN(BaseballConst.GAME_START_MESSAGE);
        return getGameCondition(BaseballUtil.getScannerStr());
    }

    /*
        게임 재시작 여부.
     */
    private static boolean getGameCondition(String str){
        if("2".equals(str))
            return false;
        return true;
    }



}
