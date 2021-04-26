import java.util.Scanner;
import java.util.regex.Pattern;

public class UserBallInput {
    private int maxLen;

    public UserBallInput(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public UserBallInput(int maxLen){
        this.maxLen = maxLen;
    }

    public String read() {
        Scanner sc = new Scanner(System.in);
        String input = null;
        input = sc.next();
        return input;
    }

    private boolean isValidatedLength(String compareStr, int compareLen) {
        return compareStr.length() == compareLen;
    }

    private boolean validateInput(String inputBall) {
        if (!isValidatedLength(inputBall, BaseballGame.DEFAULT_LEN))
            return false;
        return true;
    }

    public String userBallInputRead(String inputBall) {
        System.out.println("숫자를 입력해주세요 : ");
        if(validateInput(inputBall))
            return inputBall;
        System.out.println("올바른 입력값이 아닙니다.");
        return "FALSE";
    }



}
