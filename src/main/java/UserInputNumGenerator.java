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
        return isInputNotNull(input) && isInputLengthEqualsGamesLength(input)
                && isInputComposedOnlyOneToNine(input) && isInputComposedAllDifferentNumbers(input);
    }

    private boolean isInputNotNull(String input){
        return input != null;
    }

    private boolean isInputLengthEqualsGamesLength(String input){
        return input.length() == maxLen;
    }

    private boolean isInputComposedOnlyOneToNine(String input){

        for (int i=0; i<input.length(); i++){
            int c = input.charAt(i) - '0';

            if( !(c >= 1 && c <= 9) )
                return false;
        }

        return true;
    }

    private boolean isInputComposedAllDifferentNumbers(String input){
        long cnt = 0;

        for (int i=0; i<input.length(); i++)
            cnt += countCharacterAtIndexOnInput(input, i);

        return cnt == maxLen;
    }

    private long countCharacterAtIndexOnInput(String input, int idx){
        final char c = input.charAt(idx);
        long cnt = 0;
        String ballsArr [] = input.split("");
        for (int i=0; i<ballsArr.length; i++){
            if(ballsArr[i].charAt(0) == c){
                cnt ++;
            }
        }
        return cnt;
    }

    public String generateNum() {
        while (true){
            System.out.println("숫자를 입력해주세요 ex)123 :");
            String numbers = sc.next();

            if (validate(numbers))
                return numbers;
            System.out.println("숫자열이 유효하지 않습니다. 다시 입력해주세요");
        }
    }

    public static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2 입력하세요.");

        String selectNum = sc.next();
        if(UserSelectOption.selectOption(selectNum)){
           return true;
        }
        return false;
    }
}
