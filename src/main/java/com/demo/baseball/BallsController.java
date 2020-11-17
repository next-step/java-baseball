package com.demo.baseball;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class BallsController {

    private Balls randomBalls;
    private Balls insertBalls;
    private final Random random = new Random();

    public BallsController() {
        this.randomBalls = new Balls();
        this.insertBalls = new Balls();
    }

    public Balls getRandomBalls() {
        return randomBalls;
    }

    /**
     * 랜덤한 서로 다른 숫자 3개를 가지는 리스트를 세팅한다.
     * @return randomBalls
     */
    public List<Integer> setRandomBalls() {
        for (int i = 0; i < this.randomBalls.getListSize(); i++) {
            this.randomBalls.getBalls().add(this.makeRandomBall());
        }

        return this.randomBalls.getBalls();
    }

    /**
     * 하나의 랜덤한 숫자(1~9)를 리턴한다.
     * @return randomBall
     */
    public int makeRandomBall() {
        int number = 0;

        while (number == 0) {
            number = checkDuplication(this.random.nextInt(10));
        }

        return number;
    }

    /**
     * 이미 생성된 randomBalls에 중복되는 값이 있는지 체크
     * 중복 되는 경우 0을 리턴
     * 중복 되지 않는 경우 파라미터 값을 그대로 리턴
     * @param number
     * @return number
     */
    public int checkDuplication(int number) {
        if (number != 0 && !this.randomBalls.getBalls().contains(number)) {
            return number;
        }
        return 0;
    }

    public Balls getInsertBalls() {
        return insertBalls;
    }

    /**
     * 입력받은 3자리 숫자를 유효성 검사 후에 리스트에 세팅한다.
     * @param balls
     * @return
     * @throws Exception
     */
    public List<Integer> setInsertBalls(String balls) throws Exception {
        for (String ball : checkBalls(balls).split("")) {
            this.insertBalls.getBalls().add(Integer.parseInt(ball));
        }
        return this.insertBalls.getBalls();
    }

    /**
     * 입력받은 3자리 숫자의 패턴을 체크한다.
     * @param balls
     * @return balls
     * @throws Exception
     */
    public String checkBalls(String balls) throws Exception {
        if(balls.length() != 3 && !Pattern.matches("^[1-9]*$", balls)) {
            throw new Exception("입력 값이 올바르지 않습니다.");
        }
        return balls;
    }

}
