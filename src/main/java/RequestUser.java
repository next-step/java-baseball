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
}
