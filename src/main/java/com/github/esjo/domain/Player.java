package com.github.esjo.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import com.github.esjo.BaseBallIO;
import com.github.esjo.NumberGenerator;

public class Player {

    private static Set<Integer> numberSet;  // LinkedHashSet : 순서를 가지고 중복을 허용하지 않음.
    private static Player player;
    private static Status status = Status.INIT;

    private Player() {
    }

    private Player(Status status) {
        this.status = status;
    }

    /**Player객체 초기화 정적 메서드
     * @param numberGenerator 야구게임을 위한 numberSet을 만들기 위한 클래스
     * @param baseBallIO 사용자 입력값 처리를 위한 클래스
     * @return Player 객체 생성
     * */
    public static Player createNumberSet(NumberGenerator numberGenerator, BaseBallIO baseBallIO) {
        if (status == Status.INIT) { // 플레이어가 게임을 (재)시작 하면 객체를 새로 생성한다.
            player = new Player(Status.PLAY);
        }
        readValidNumber(numberGenerator, baseBallIO);
        return player;
    }

    /**
     * 유효한값이 될때까지, 사용자로 부터 입력을 받는다.
     * */
    private static void readValidNumber(NumberGenerator numberGenerator, BaseBallIO baseBallIO) {
        boolean flag = false;
        do {
            flag = player.readNumber(numberGenerator, baseBallIO);
        } while (!flag);
    }

    /**
     * 사용자로 부터 입력을 받는다.
     * @return boolean 입력값의 유효함 여부
     * */
    private boolean readNumber(NumberGenerator numberGenerator, BaseBallIO baseBallIO) {
        try {
            System.out.print("숫자를입력해주세요: ");
            numberSet = new LinkedHashSet<>();
            numberGenerator.generateThreeDigitsByInput(baseBallIO).digitsToSet(numberSet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /** getter for numberSet */
    public Set<Integer> getNumberSet() {
        return numberSet;
    }

    /** setter for numberSet */
    public void setNumberSet(Set<Integer> numberSet) {
        this.numberSet = numberSet;
    }

    /** getter for status */
    public Status getStatus() {
        return status;
    }

    /** setter for status */
    public void setStatus(Status status) {
        this.status = status;
    }
}
