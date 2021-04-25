import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class BaseballGame {

    private final BaseballGameView gameView = new BaseballGameView();
    private final Random random = new Random();
    HashSet<Integer> set = null;

    //게임 시작 로직
    public boolean baseballGameStart() {
        set = new HashSet<>();
        int[] computerGameNumber = makeComputerGameNumber();
        boolean finishGame = false;
        
        do {
            finishGame = progressGame(computerGameNumber);
        } while (!finishGame);

        return restartGame();
    }

    //게임 종료 후 재시작 유무 질의
    private boolean restartGame() {
        String input = gameView.getGameRestart().trim();
        boolean isValid = checkRestartValid(input);

        while (!isValid){
            input = gameView.getGameRestart().trim();
            isValid = checkRestartValid(input);
        }

        if(input.equals("1")) return true;
        return false;
    }

    private boolean checkRestartValid(String input) {
        if(input.equals("1")||input.equals("2")) return true;
        return false;
    }

    //게임 진행 로직
    private boolean progressGame(int[] computerGameNumber) {
        System.out.println(Arrays.toString(computerGameNumber));
        String input = gameView.getUserNumber().trim();
        boolean isValid = checkNumberValid(input);

        while (!isValid) {
            input = gameView.getUserNumber().trim();
            isValid = checkNumberValid(input);
        }

        int[] userNumber = parseUserNumber(input);

        BaseballGameResult result = new BaseballGameResult();
        result.setStrike(getStrike(computerGameNumber, userNumber));
        result.setBall(getBall(computerGameNumber, userNumber));

        if(result.isFinish()) return true;

        gameView.printGameResult(result.isNothing()? "낫싱":result.toString());
        return false;
    }

    private int getBall(int[] computerGameNumber, int[] userNumber) {
        int ball = 0;
        int idx = 0;

        while (idx < 3) {
            ball = set.contains(userNumber[idx])? ball+1:ball;
            ball = computerGameNumber[idx]==userNumber[idx]? ball-1:ball;
            idx++;
        }

        return ball;
    }

    private int getStrike(int[] computerGameNumber, int[] userNumber) {
        int strike = 0;
        int idx = 0;

        while (idx < 3) {
            strike = computerGameNumber[idx]==userNumber[idx]? strike+1:strike;
            idx++;
        }

        return strike;
    }

    private int[] parseUserNumber(String input) {
        int[] userNumbers = new int[3];

        for(int i = 0; i < 3; i++){
            userNumbers[i] = input.charAt(i) - '0';
        }

        return userNumbers;
    }

    //valid check
    private boolean checkNumberValid(String input) {
        if(input.length() != 3) return false;
        String regExp = "^[1-9]+$";

        if(!input.matches(regExp)) return false;
        return true;
    }

    //컴퓨터 3자리 난수 생성
    private int[] makeComputerGameNumber() {
        int[] numbers = new int[3];
        int idx = 0;

        while (idx < 3) {
            numbers[idx++] = getRandomNumber();
        }

        return numbers;
    }

    private int getRandomNumber() {
        int number = random.nextInt(8) + 1;

        while (set.contains(number)) {
            number = random.nextInt(8) + 1;
        }

        set.add(number);
        return number;
    }


}
