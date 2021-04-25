import java.util.Random;

public class BaseballGame {

    private final BaseballGameView gameView = new BaseballGameView();

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

    }



}
