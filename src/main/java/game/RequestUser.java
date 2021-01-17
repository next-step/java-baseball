package game;

import java.util.Scanner;

public class RequestUser {

    Scanner sc = new Scanner(System.in);

    public GameInfo askUserForSuitableNum() {
        NumberUtil numberUtil = new NumberUtil();
        String userNumber;
        while (true) {
            System.out.println(ConstantString.REQUEST_NUM_INPUT);
            userNumber = sc.next();
            if (numberUtil.isSuitableNumber(userNumber)) {
                break;
            }
        }
        GameInfo userInfo = new GameInfo(userNumber);
        return userInfo;
    }

    public Boolean askUserForRenewGame() {
        InternalGame internalGame = new InternalGame();
        System.out.println(ConstantString.GAME_RESUMPTION);
        String userAnswer = sc.next();
        return internalGame.isGameRenew(userAnswer);
    }
}
