package domain.participants;

import domain.Numbers;
import view.Message;
import view.OutputMessage;

public class Umpire {

    private int strike;
    private int ball;

    public Umpire() { }

    public void requestInput() {
        OutputMessage.printMessage(Message.REQUEST_INPUT);
    }

    public void makeJudgement(Numbers answer, Numbers guess) {
        initScore();
        boolean isStrike;
        for(int i=0;i<Numbers.MAX_SIZE;i++){
            isStrike = false;
            isStrike = checkStrike(answer, guess, i);
            if(!isStrike) checkBall(answer, guess, i);
        }
        noticeResult();
    }

    private void noticeResult() {
        OutputMessage.printResult(strike,ball);
    }

    private void checkBall(Numbers answer, Numbers guess, int idx) {
        if(answer.getDigits().contains(guess.getDigits().get(idx))) ball++;
    }

    private boolean checkStrike(Numbers answer, Numbers guess, int idx) {
        if(answer.getDigits().get(idx) == guess.getDigits().get(idx)) {
            strike++;
            return true;
        }
        return false;
    }

    public void initScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall(){
        return ball;
    }

    public void askAnotherRound() {
        initScore();
        OutputMessage.printMessage(Numbers.MAX_SIZE,Message.NOTICE_ANSWER);
        OutputMessage.printMessage(Message.ASK_NEXT_GAME);
    }
}
