package com.tistory.javapanda.baseball.service;

import com.tistory.javapanda.baseball.vo.BaseBallVo;

import java.util.*;

public class BaseBallService {

    private List<Integer> randomNumbers;
    private Scanner scanner = new Scanner(System.in);

    public BaseBallService(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public BaseBallVo play(List<Integer> inputNumbers) {
        int strike = getStrike(inputNumbers);
        int ball = getBall(inputNumbers);
        return new BaseBallVo(strike, ball);
    }

    public int getStrike(List<Integer> inputNumbers) {
        int strike = 0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) == inputNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall(List<Integer> inputNumbers) {
        int ball = 0;
        Map<Integer, Integer> ballCount = new HashMap<>();
        for (int i = 0; i < randomNumbers.size(); i++) {
            ballCount.put(randomNumbers.get(i), ballCount.getOrDefault(randomNumbers.get(i), 0)+1);
        }
        for (int i = 0; i<inputNumbers.size(); i++) {
            if(randomNumbers.get(i) != inputNumbers.get(i) && ballCount.containsKey(inputNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public List<Integer> validateInputNumbers() {
        String input = scanner.nextLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해주세요.");
        }
        return parseInputNumbers(input);
    }

    public List<Integer> parseInputNumbers(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
            inputNumbers.add(input.charAt(i)+'0');
        }
        return inputNumbers;
    }


}
