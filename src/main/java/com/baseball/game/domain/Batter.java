package com.baseball.game.domain;

import com.baseball.game.exception.BaseBallException;

import java.util.ArrayList;
import java.util.List;

public class Batter {

        private List<NumberBox> numberBox;

    public Batter(int swingNumbers){
        createBatterBox(swingNumbers);
    }

    public static Batter create(int swingNumbers){
        return new Batter(swingNumbers);
    }

    private void createBatterBox(int swingNumbers) {
        numberBox = new ArrayList<>();
        isNumberRange(swingNumbers);

        int idx = 0;
        for (String number : splitSwingNumber(swingNumbers)){
            int inputNum = parsingNumber(number);
            isDuplicated(inputNum);
            numberBox.add(NumberBox.of(idx, inputNum));
        }
    }

    private String[] splitSwingNumber(int swingNumbers){
        return String.valueOf(swingNumbers).split("");
    }

    private int parsingNumber(String number){
        return Integer.parseInt(number);
    }

    private void isNumberRange(int num){
        if(num < 1 || num > 1_000){
            throw new BaseBallException("0 ~ 1,000 사이의 숫자만 입력해 주세요");
        }
    }

    private void isDuplicated(int num) {
        numberBox.listIterator().forEachRemaining(box -> {
            if(box.equalsNumber(num)){
                throw new BaseBallException("1~9까지 서로 다른 3자리 숫자로 입력해 주세요");
            }
        });
    }

    public int getNumberFromIndex(int idx) {
        return numberBox.get(idx).getNumber();
    }

    public List<NumberBox> getNumberBox() {
        return numberBox;
    }

    @Override
    public String toString(){
        String result = "";

        for (NumberBox batter : this.numberBox){
            result += batter.getNumber();
        }

        return result;
    }
}
