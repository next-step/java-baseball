package me.nimkoes.baseball.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.model.RandomNumberRepository;

public class BaseballService {

    private static final BaseballService baseballService = new BaseballService();

    private static RandomNumberRepository randomNumberRepository;

    private Random random = new Random();

    public static BaseballService getInstance(RandomNumberRepository randomNumberRepository) {
        BaseballService.randomNumberRepository = randomNumberRepository;
        return baseballService;
    }

    private BaseballService() {}

    private boolean gameOver = false;

    /*
     * 새로운 난수를 저장
     */
    public void makeRandomNumber() {
        randomNumberRepository.setTargetNumber(generateRandomNumber());
    }

    /*
     * 새로운 난수 생성
     */
    private String generateRandomNumber() {
        Set<Integer> randomIntSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        while (randomIntSet.size() < MainLauncher.LENGTH_OF_NUMBER) {
            randomIntSet.add(random.nextInt(10));
        }

        return setToString(randomIntSet);
    }

    /*
     * 순서가 있는 정수로 이루어진 Set 데이터를 문자열로 만들어 반환
     */
    private String setToString(Set<Integer> randomIntSet) {
        StringBuilder sb = new StringBuilder();

        for (Integer integer : randomIntSet) {
            sb.append(integer);
        }

        return sb.toString();
    }

    /*
     * 입력받은 수의 strike 개수를 반환
     */
    public int getStrikeCount(String input) {
        int strikeCount = 0;
        for (int i = 0; i < MainLauncher.LENGTH_OF_NUMBER; ++i) {
            strikeCount += checkStrike(randomNumberRepository.getTargetNumber(), input, i);
        }

        if (strikeCount == MainLauncher.LENGTH_OF_NUMBER) {
            this.gameOver = true;
        }
        return strikeCount;
    }

    /*
     * 입력받은 수의 ball 개수를 반환
     */
    public int getBallCount(String input) {
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

    /*
     * gameOver 값을 false 로 세팅
     */
    public void gameStart() {
        this.gameOver = false;
    }

    /*
     * 생성 된 난수를 맞췄을 경우 true 를 반환
     */
    public boolean isGameOver() {
        return gameOver;
    }

}
