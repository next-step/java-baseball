import java.util.Scanner;

public class RequestUser {

    public GameInfo askUserForSuitableNum() {
        Scanner sc = new Scanner(System.in);
        InternalGame internalGame = new InternalGame();
        String userNumber;
        while (true) {
            System.out.println(ConstantString.REQUEST_NUM_INPUT);
            userNumber = sc.next();
            if (internalGame.isSuitableNumber(userNumber)) {
                break;
            }
        }
        GameInfo userInfo = new GameInfo(userNumber);
        return userInfo;
    }

    public Boolean askUserForRenewGame() {
        InternalGame internalGame = new InternalGame();
        Scanner sc = new Scanner(System.in);
        System.out.println(ConstantString.GAME_RESUMPTION);
        String userAnswer = sc.next();
        return internalGame.isGameRenew(userAnswer);
    }
}
