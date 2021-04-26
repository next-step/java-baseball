package numbaseball;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame(){
        //3자리 난수 arrayList 생성
        List<Integer> playNumber = Play.createPlayNumber();
        playGame(playNumber);
    }

    private static void playGame(List<Integer> playNumber) {
        Ui.startPlayGame();
        List<Integer> inputNumber = Play.getInputNumber();
        Map<String, Object> playResult = Play.judge(playNumber, inputNumber);
        Ui.judgePlayGame(playResult);
    }


}

