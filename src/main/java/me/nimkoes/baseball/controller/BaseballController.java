package me.nimkoes.baseball.controller;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.model.RandomNumberRepository;
import me.nimkoes.baseball.view.PlayerInterface;


public class BaseballController {

    private final PlayerInterface playerInterface;
    private final RandomNumberRepository randomNumberRepository;

    public BaseballController(PlayerInterface playerInterface) {
        this.playerInterface = playerInterface;
        this.randomNumberRepository = RandomNumberRepository.getInstance();
    }

    private void playBall() {

        String userInput = playerInterface.inputNumber();  // 사용자 입력
        int strikeCount = getStrikeCount(userInput);       // strike 계산
        int ballCount = getBallCount(userInput);           // ball 계산

        playerInterface.printCountMessage(strikeCount, ballCount);  // 비교 결과 출력
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
     * 입력받은 수의 ball 개수를 반환
     */
    private int getBallCount(String input) {
        int ballCount = 0;
        for (int i = 0; i < MainLauncher.LENGTH_OF_NUMBER; ++i) {
            ballCount += checkBall(randomNumberRepository.getTargetNumber(), input, i);
        }
        return ballCount;
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

    /*
     * 중복 숫자는 존재하지 않기 때문에
     * 검사 대상 위치의 값이 strike 인 경우 ball 이 아님
     * strike 가 아닌 경우 다른 위치에서 값이 발견 되는지 확인하여 ball 인지 판단
     */
    private int checkBall(String target, String input, int index) {
        if (checkStrike(target, input, index) == 1) {
            return 0;
        }
        if (target.indexOf(input.charAt(index)) == -1) {
            return 0;
        }
        return 1;
    }

}
