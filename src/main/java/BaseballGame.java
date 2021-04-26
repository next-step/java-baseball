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
}