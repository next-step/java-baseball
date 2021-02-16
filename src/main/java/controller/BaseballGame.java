package controller;

import model.BallNumber;
import model.BaseBallNumbers;
import model.Computer;
import model.Player;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {

    private static final int RESTART_SIGNAL = 1;

    Computer computer;
    Player player;
    InputView inputView;

    public BaseballGame() {
        computer = Computer.of();
        player = Player.of();
        inputView = new InputView();
    }

    public void start() {

        do {
//        1. 컴퓨터의 수를 초기화한다.
//                - 수 3개는 중복이어서는 안된다.
            computer.shuffleBaseBallNumbers();
            processGameUntilAllStrikes();
            //        6. 3스트라이크인 경우 게임종료 메시지 출력
            ResultView.printGameSet();
        } while (inputView.getRestartInput() == RESTART_SIGNAL);

//        7. 새로 시작 or 종료 안내 메시지를 출력
//        8. 사용자 입력을 받는다.
//        9. '1'일 경우 1로 돌아간다.
//        10. '2'일 경우 종료한다.
    }

    private boolean isGameSet(int strike) {
        return strike != 3;
    }

    private void processGameUntilAllStrikes() {

        do {
            gamePhase();
        } while (isGameSet(player.getStrike()));

    }

    private List<BallNumber> parseToBallNumbers(String input) {
        String[] inputs = input.split("");
        List<BallNumber> ballNumbers = new ArrayList<>();
        Arrays.stream(inputs).forEach(s -> ballNumbers.add(BallNumber.of(Integer.parseInt(s))));
        return ballNumbers;
    }

    private void gamePhase() {
//        2. 플레이어에게 입력을 요구한다.
//                - 입력은 1-9 숫자 이외의 수이면 안된다.
        String playersNumbers = inputView.getPlayersNumbers();
        BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(parseToBallNumbers(playersNumbers));
        player.setBaseBallNumbers(baseBallNumbers);
//        3. 입력받는 숫자열과 컴퓨터 수를 대조한다.
//                - 스트라이크와 볼은 중복되지 아니한다.
        computer.startChecking(player);
//        4. 결과를 출력한다.
        ResultView.printResult(player.getStrike(), player.getBall());
//        5. 3스트라이크가 아닌경우 2로 돌아간다.
    }

}
