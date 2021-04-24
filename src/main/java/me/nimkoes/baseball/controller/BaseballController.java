package me.nimkoes.baseball.controller;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.model.RandomNumberRepository;


public class BaseballController {

    private final RandomNumberRepository randomNumberRepository;


    public BaseballController() {
        this.randomNumberRepository = RandomNumberRepository.getInstance();
    }

    /*
     * 새로운 난수를 생성
     */
    private String generateRandomNumber() {
        Set<Integer> integers = new LinkedHashSet<>();
        Random random = new Random();

        while (integers.size() < MainLauncher.LENGTH_OF_NUMBER) {
            integers.add(random.nextInt(10));
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : integers) {
            sb.append(integer);
        }

        return sb.toString();
    }

    /*
     * 입력받은 수의 strike 개수를 반환
     */
    private int getStrikeCount(String input) {
        int strikeCount = 0;
        for (int i = 0; i < MainLauncher.LENGTH_OF_NUMBER; ++i) {
            strikeCount += checkStrike(randomNumberRepository.getTargetNumber(), input, i);
        }
        return strikeCount;
    }

    /*
     * 동일한 위치의 값이 같으면 strike 로 판단
     */
    private int checkStrike(String target, String input, int index) {
        if (target.charAt(index) == input.charAt(index)) {
            return 1;
        }
        return 0;
    }

}
