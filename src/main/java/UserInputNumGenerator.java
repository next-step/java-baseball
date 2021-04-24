import java.util.Scanner;

public class UserInputNumGenerator {
    private int maxLen;
    private static Scanner sc = new Scanner(System.in);

    public UserInputNumGenerator(){
        this(BaseballGame.DEFAULT_LEN);
    }

    public UserInputNumGenerator(int maxLen){
        this.maxLen = maxLen;
    }

    public boolean validate(String input) {
        return isInputNotNull(input);
    }
    private boolean isInputNotNull(String input){
        return input != null;
    }
}
