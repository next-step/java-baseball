package com.test.baseball;

import java.util.List;
import java.util.Random;

public class BaseballGame {
    private final BaseballUser USER = new BaseballUser();

    public static void main(String[] args){
        new BaseballGame().run();
    }

    public void run() {
        do {
            System.out.println("게임을 시작 합니다");
            play();
        } while(USER.isRestart());
        System.out.println("게임을 종료 합니다");
    }

    private void play() {
        List<Integer> numbers = createRandomNumbers();
        BaseballCounter counter = new BaseballCounter(numbers);

        while(!counter.isFinished()) {
            counter.clear();
            List<Integer> enterNumbers = USER.getInputNumbers();
            count(counter, enterNumbers);
            printMessage(counter);
        }
    }

    private void printMessage(BaseballCounter counter) {
        if(counter.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String strikeMessage = (counter.getStrikeCount()==0)?"":counter.getStrikeCount() + " 스트라이크 ";
        String ballMessage = (counter.getBallCount()==0)?"":counter.getBallCount() + " 볼";
        String finishMessage = (!counter.isFinished())?"":"\r\n3개의 숫자를 모두 맞히셨습니다! 게임종료";
        System.out.println(strikeMessage + ballMessage + finishMessage);
    }

    private void count(BaseballCounter counter, List<Integer> enterNumbers){
        for(int ix = 0 ; ix < BaseballConstant.NUMBER_COUNT ; ix ++) {
            counter.chekAndSetCount(ix, enterNumbers.get(ix));
        }
    }

    private List<Integer> createRandomNumbers(){
        NotDuplicateList numbers = new NotDuplicateList(BaseballConstant.NUMBER_COUNT);
        Random r = new Random();
        while(!numbers.isFull()) {
            int number = r.nextInt(9) + 1;
            numbers.add(number);
        }
        return numbers;
    }
}
