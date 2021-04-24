package me.nimkoes.baseball.controller;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.nimkoes.baseball.MainLauncher;

public class BaseballController {

    public BaseballController() {}

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

}
