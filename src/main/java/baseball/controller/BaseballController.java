package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    public void play(){
        init();

        playGame();

        end();
    }


    private void init() {
    }

    private void playGame() {
        while(playAgain){
            playOnce();
            playAgain = end();
        }
    }

    private void playOnce() {
        while(!isEnd){
            OutputView.inputNumber();
            numbers = InputView.inputNumber();
            isEnd = compareNumbers(numbers); // 컴퓨터와 플레이어의 숫자를 비교
            OutputView.result();//3개의 숫자를 모두 맞히셨습니다! 게임 종료
        }
    }

    private boolean compareNumbers(){
        // 컴퓨터와 사람의 숫자를 비교하는 로직.
    }

    private boolean end() {
        OutputView.end();
        return InputView.askEnd();
    }
}
