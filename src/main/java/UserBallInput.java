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

    private boolean compareDigital(String compareStr) {
        return Pattern.matches("^[1-9]", compareStr);
    }

    private boolean isValidatedDigital(String compareStr) {
        boolean isDigital = true;
        for (int i=0; i<compareStr.length(); i++)
            isDigital = isDigital && compareDigital(compareStr.charAt(i) + "");
        return isDigital;
    }

    private int getStrNumber(String compareStr, char compareChr) {
        int cnt = 0;

        for(int i=0;i<compareStr.length();i++)
            cnt += compareStr.charAt(i) == compareChr ? 1 : 0;

        return cnt;
    }

    private boolean compareUnique(String compareStr, char compareChr) {
        return getStrNumber(compareStr,compareChr) == 1;
    }

    private boolean isValidatedUnique(String compareStr) {
        boolean isUnique = true;
        for(int i=0;i<compareStr.length();i++)
            isUnique = isUnique && compareUnique(compareStr, compareStr.charAt(i));
        return isUnique;
    }

    private boolean validateInput(String inputBall) {
        if (!isValidatedLength(inputBall, BaseballGame.DEFAULT_LEN))
            return false;
        if(!isValidatedDigital(inputBall))
            return false;
        if(!isValidatedUnique(inputBall))
            return false;
        return true;
    }

    public String userBallInputRead(String inputBall) {
        System.out.print("숫자를 입력해주세요 : ");
        if(validateInput(inputBall))
            return inputBall;
        System.out.println("올바른 입력값이 아닙니다.");
        return "FALSE";
    }

    public String userBallInputRead() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBall = read();
        if(validateInput(inputBall))
            return inputBall;
        System.out.println("올바른 입력값이 아닙니다.");
        return "FALSE";
    }

    public String userBallInput() {
        String userInputRead = "FALSE";
        while(userInputRead == "FALSE")
            userInputRead = userBallInputRead();
        return userInputRead;
    }
}
