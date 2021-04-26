import java.util.*;

public class BaseballGame {
    private static final String INPUT_PRINT = "숫자를 입력해주세요:";
    private static final String CORRECT_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String RESTART_INPUT_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Integer MAX_LEN = 3;

    static private Scanner sc;
    static private Random random;

    public BaseballGame(){
        sc = new Scanner(System.in);
        random = new Random();
    }

    public List<Integer> createRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_LEN; i++) {
            randomNumbers.add(random.nextInt(9)+1);
        }
        return randomNumbers;
    }

    public List<Integer> inputUserNumber(){
        System.out.print(INPUT_PRINT);
        String userNumber = sc.nextLine();
        while (!validateUserNumber(userNumber)) {
            userNumber = sc.nextLine();
        }
        return toIntegerList(userNumber);
    }

    public boolean validateUserNumber(String userNumber) {
        if ( userNumber.length() != MAX_LEN) {
            System.out.print(INPUT_PRINT);
            return false;
        }
        return true;
    }

    public List<Integer> toIntegerList(String userNumber) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < MAX_LEN; i++) {
            answer.add(Integer.parseInt(String.valueOf(userNumber.charAt(i))));
        }
        return answer;
    }

    public BaseballResult calculateResult(List<Integer> randomNumber, List<Integer> userNumber){
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < MAX_LEN; i++) {
            strike += checkStrike(randomNumber.get(i), userNumber.get(i));
            ball += checkBall(randomNumber.get(i), userNumber, i);
        }
        return new BaseballResult(strike, ball);
    }

    public int checkStrike(int randomNumber, int userNumber){
        if (randomNumber == userNumber){
            return 1;
        }
        return 0;
    }

    public int checkBall(int randomNumber, List<Integer> userNumber, int index) {
        if (randomNumber == userNumber.get(0) && index != 0){
            return 1;
        }
        if (randomNumber == userNumber.get(1) && index != 1){
            return 1;
        }
        if (randomNumber == userNumber.get(2) && index != 2){
            return 1;
        }
        return 0;
    }

    public void printResult(BaseballResult baseballResult){
        System.out.println(baseballResult.toString());
    }
}