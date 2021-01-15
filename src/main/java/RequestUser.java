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

    public String askUserForResumeGame(GameInfo gameResultInfo) {
        if (!gameResultInfo.isGameResumption()) {
            String st = askResume();
            switch (st) {
                case "1":
                    return "1";
                case "2":
                    return "2";
                default:
                    st = askResume();
            }
        }
        return null;
    }

    private String askResume() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConstantString.GAME_RESUMPTION);
        String st = sc.next();
        return st;
    }
}
