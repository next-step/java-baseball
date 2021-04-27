package numbaseball;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame(){
        List<Integer> playNumber = Play.createPlayNumber();
        while(playGame(playNumber));

        Ui.endPlayGame();
        if ( Play.IsRestartGame() ){
            startGame();
        }

    }

    private static boolean playGame(List<Integer> playNumber) {
        Ui.startPlayGame();
        List<Integer> inputNumber = Play.getInputNumber();
        Map<String, Object> playResult = Play.judge(playNumber, inputNumber);

        Ui.judgePlayGame(playResult);
        return Play.isEndGame(playResult);
    }

}

