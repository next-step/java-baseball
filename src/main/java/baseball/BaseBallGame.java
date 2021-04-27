package baseball;

import baseball.enumerator.GameProgress;
import opponent.entity.Computer;
import opponent.Opponent;
import view.InputDevice;
import view.OutputDevice;

import java.util.List;

public class BaseBallGame {

    private static boolean right;
    private GameProgress gameProgress;
    private Result result;

    /* *
     * 게임이 시작되면 상대방은 제출할 문제를 생성한다.
     * 문제가 생성되면 게임이 시작된다.
     * 플레이어는 문제를 푼다.
     */

    public void play() {
        Opponent opponent = new Computer();
        while (GameProgress.EXIT != gameProgress){
            List<BaseballNumber> answer = opponent.generateAnswer();
            confirmCorrectAnswer(answer);
            OutputDevice.printAskForRestart();
            gameProgress = InputDevice.inputProcessCode();
            right = false;
        }
        /* 게임 종료 */
        OutputDevice.printCorrectMessage();
    }

    private void confirmCorrectAnswer(List<BaseballNumber> answer) {
        while (!right){
            OutputDevice.printInputNumbersMessage();
            List<BaseballNumber> playerSubmitted = InputDevice.inputNumber();
            Result result = new Result(answer, playerSubmitted);
            printResult(result);
        }
    }

    private void printResult(Result result){
        if(result.getStrike() == 3){
            OutputDevice.printCorrectMessage();
            right = true;
        }
        if(result.getStrike() == 0 && result.getBall() == 0){
            OutputDevice.printNothingResult();
        }
        if(result.getStrike() > 0 && result.getBall() > 0){
            OutputDevice.printMixResult(result.getStrike(), result.getBall());
        }
        if(result.getStrike() > 0 && result.getBall() == 0){
            OutputDevice.printStrikeResult(result.getStrike());
        }
        if(result.getBall() > 0 && result.getStrike() == 0){
            OutputDevice.printBallResult(result.getBall());
        }
    }
}
