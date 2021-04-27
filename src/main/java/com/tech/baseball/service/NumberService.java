package com.tech.baseball.service;

import java.util.HashSet;
import java.util.Random;

public class NumberService {

    private Random random = new Random();
    private HashSet<Integer> set = new HashSet<>();

    public int[] parseUserNumber(String input) {
        int[] userNumbers = new int[3];

        for(int i = 0; i < 3; i++){
            userNumbers[i] = input.charAt(i) - '0';
        }

        return userNumbers;
    }

    //컴퓨터 3자리 난수 생성
    public int[] makeComputerGameNumber() {
        int[] numbers = new int[3];
        int idx = 0;
        set = new HashSet<>();

        while (idx < 3) {
            numbers[idx++] = getRandomNumber();
        }

        return numbers;
    }

    public int getRandomNumber() {
        int number = random.nextInt(8) + 1;

        while (set.contains(number)) {
            number = random.nextInt(8) + 1;
        }

        set.add(number);
        return number;
    }
}
