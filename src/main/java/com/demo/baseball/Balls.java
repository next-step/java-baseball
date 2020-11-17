package com.demo.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int DEFAULT_LIST_SIZE = 3;
    private int listSize;
    private String input;
    private List<Integer> balls;

    public Balls() {
        this(DEFAULT_LIST_SIZE);
    }

    private Balls(int size) {
        this.balls = new ArrayList<>(size);
        this.listSize = size;
    }

    public static int getDefaultListSize() {
        return DEFAULT_LIST_SIZE;
    }

    public int getListSize() {
        return listSize;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < balls.size(); i++) {
            sb.append(balls.get(i));
        }
        this.input = sb.toString();
    }

    public String getInput() {
        if(this.input == null || this.input.isEmpty()) {
            this.setInput();
        }
        return this.input;
    }

    public List<Integer> getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return "Balls{" + balls.toString() + '}';
    }
}
