import java.util.HashSet;
import java.util.Random;

public class BaseballGame {

    private final BaseballGameView gameView = new BaseballGameView();
    private final Random random = new Random();
    HashSet<Integer> set = new HashSet<>();

    //게임 시작 로직
    public boolean baseballGameStart() {
        int[] computerGameNumber = makeComputerGameNumber();
        boolean finishGame = false;
        
        do {
            finishGame = progressGame();
        } while (!finishGame);

        return restartGame();
    }

    //게임 종료 후 재시작 유무 질의
    private boolean restartGame() {

    }

    //게임 진행 로직
    private boolean progressGame() {

    }

    //컴퓨터 3자리 난수 출력
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
        while(set.contains(number)){
            number = random.nextInt(8) + 1;
        }
        set.add(number);
        return number;
    }


}
