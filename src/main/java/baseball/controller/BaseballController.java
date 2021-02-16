package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private boolean playAgain;
    private boolean isEnd;
    private Baseball baseball;

    public void play(){
        init();
        playGame();
    }


    private void init() {
        playAgain = true;
        baseball = new Baseball();
    }

    private void playGame() {
        while(playAgain){
            playOnce();
            playAgain = end();
        }
    }

    private void playOnce() {
        // 컴퓨터 난수 & 플레이어 win-loss 상태 초기화.
        baseball.initGame();

        baseball.printComputerNumbers(); // c.f. 테스팅 단계에서만 사용.
        isEnd = false;
        while(!isEnd){
            OutputView.inputNumber(); // 숫자를 입력해 주세요.
            String numbers = InputView.inputNumber();
            isEnd = baseball.compareNumbers(numbers); // 컴퓨터와 플레이어의 숫자를 비교
        }
        OutputView.result();//3개의 숫자를 모두 맞히셨습니다! 게임 종료
    }

    private boolean end() {
        OutputView.end();
        return InputView.askEnd();
    }
}
