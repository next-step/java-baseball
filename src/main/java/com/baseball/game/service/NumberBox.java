package com.baseball.game.service;

import com.baseball.game.exception.BaseBallException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NumberBox {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 9;

    private List<Integer> numberBox;

    public NumberBox(){
        numberBox = new ArrayList<>();
        createPitcherBox();
    }

    public NumberBox(int swingNumbers){
        createBatterBox(swingNumbers);
    }

    public static NumberBox generate(){
        return new NumberBox();
    }

    public static NumberBox generate(int swingNumbers){
        return new NumberBox(swingNumbers);
    }

    private void createPitcherBox() {
        for (int i = 0; i < 3 ; i++) {
            numberBox.add(getDistinctValue());
        }
    }

    protected int getDistinctValue(){
        int input = new Random().nextInt(MAX_VALUE) + MIN_VALUE;
        if(numberBox.contains(input)){
            return getDistinctValue();
        }

        return input;
    }

    private void createBatterBox(int swingNumbers) {
        numberBox = new ArrayList<>();
        isNumberRange(swingNumbers);

        for (String number : splitSwingNumber(swingNumbers)){
            int inputNum = parsingNumber(number);
            isDuplicated(inputNum);
            numberBox.add(inputNum);
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
        if (numberBox.contains(num)) {
            throw new BaseBallException("1~9까지 서로 다른 3자리 숫자로 입력해 주세요");
        }
    }

    public List<Integer> getNumberBox() {
        return numberBox;
    }

    void setNumberBox(List<Integer> numberBox) {
        this.numberBox = numberBox;
    }

    @Override
    public String toString(){
        String result = "";

        for (Integer num : this.numberBox){
            result += num;
        }

        return result;
    }
}
