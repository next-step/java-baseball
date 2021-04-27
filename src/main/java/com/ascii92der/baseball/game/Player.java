package com.ascii92der.baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Integer> numberList;

    public Player() {
    }

    public Player(String inputNumberString) {
        setPlayerList(inputNumberString);
    }

    public void setPlayerList(String inputString) {
        numberList = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            numberList.add(Integer.parseInt(inputString.charAt(i) + ""));
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
