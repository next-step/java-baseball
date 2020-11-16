package com.baseball.game.service;

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

    public NumberBox(String swingNumbers){
        numberBox = new ArrayList<>();
        validate();
    }

    public static NumberBox generate(){
        return new NumberBox();
    }

    public static NumberBox generate(String swingNumbers){
        return new NumberBox();
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

    // TODO: BaseBallException 구현하기
    private void validate(){

    }

    public List<Integer> getNumberBox() {
        return numberBox;
    }

    void setNumberBox(List<Integer> numberBox) {
        this.numberBox = numberBox;
    }
}
