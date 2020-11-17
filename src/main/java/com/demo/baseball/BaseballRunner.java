package com.demo.baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BaseballRunner {

    private Scanner scanner;

    private BallsController ballsController;
    private DecisionController decisionController;

    public BaseballRunner() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * running baseball game.
     */
    public void run() {
        boolean continueGame = true;
        while (continueGame) {
            this.startGame();
            this.playGame();
            continueGame = this.endGame();
        }
    }

    /**
     * initialize controller and new random-balls.
     */
    public void startGame() {
        this.ballsController = new BallsController();
        this.decisionController = new DecisionController(this.ballsController);
        this.ballsController.setRandomBalls();
    }

    /**
     * play game!
     * user insert three-length number.
     */
    public void playGame() {
        boolean isAskAgain = true;
        while (isAskAgain) {
            System.out.print("숫자를 입력해주세요 : ");
            String insertBalls = this.scanner.next();
            try {
                this.ballsController.setInsertBalls(insertBalls);
                isAskAgain = this.decide();
            } catch (Exception e) {
                System.out.println("올바른 값을 입력해주세요.");
            }
        }
    }

    /**
     * decide random balls and insert balls.
     * @return isAskAgain
     */
    public boolean decide() {
        this.decisionController.setDecision();
        Decision decision = this.decisionController.getDecision();
        return this.printDecision(decision);
    }

    /**
     * after decide, print decision.
     * @param decision
     * @return
     */
    public boolean printDecision(Decision decision) {
        if(decision.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        System.out.println(decision);
        return true;
    }

    /**
     * ask end game.
     * @return isEndGame
     */
    public boolean endGame() {
        int askAgain = 0;
        while (askAgain == 0) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String next = this.scanner.next();
            askAgain = this.checkContinue(next);
        }
        if(askAgain == 1) {
            return true;
        }
        return false;
    }

    /**
     * check continue pattern.
     * @param enterValue
     * @return int
     */
    public int checkContinue(String enterValue) {
        if(enterValue.length() != 1 || !Pattern.matches("^[1-2]*$", enterValue)) {
            System.out.println("올바른 값을 입력해주세요.");
            return 0;
        }
        return Integer.parseInt(enterValue);
    }
}
