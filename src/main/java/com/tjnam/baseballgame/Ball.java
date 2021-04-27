package com.tjnam.baseballgame;

import java.util.Arrays;

    public class Ball {
        final int BALL_LENGTH = 3;
        final int BALL_RANGE = 10;
        private int[] ballValues;
        private Boolean[] ballExists;

        public Ball() {
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
        }

        public Ball(int[] selection) {
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
            this.setBallValues(selection);
        }

        public Ball(String numbers) {
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
            this.setBallValues(numbers);
        }

        public void setRandomBalls() {
            int[] randomBalls = this.getRandomNumbers();
            this.setBallValues(randomBalls);
        }

        public void setBallValues(int[] selection) {
            this.ballValues = selection;
            this.markValueExist();
        }

        public void setBallValues(String numbers) {
            this.ballValues[0] = Integer.parseInt(String.valueOf(numbers.charAt(0)));
            this.ballValues[1] = Integer.parseInt(String.valueOf(numbers.charAt(1)));
            this.ballValues[2] = Integer.parseInt(String.valueOf(numbers.charAt(2)));
            this.markValueExist();
        }

        public int[] getNumbers() {
            return this.ballValues;
        }

        public GameResult compareBalls(Ball compareTarget){
            GameResult gameResult = new GameResult();

            int[] targetBallValue = compareTarget.getNumbers();

            for (int i=0 ; i<3 ; i++) {
                Boolean isStrike = this.countStrike(gameResult, this.ballValues[i], targetBallValue[i]);
                if (!isStrike) {
                    this.countBall(gameResult, targetBallValue[i]);
                }
            }
            return gameResult;
        }

        private int[] getRandomNumbers() {
            int[] numbers = new int[BALL_LENGTH];
            boolean[] numberCheck = new boolean[BALL_RANGE];
            int count=0;
            do {
                int pick = (((int) (Math.random() * 10)) % 9) + 1;
                if (!numberCheck[pick]) {
                    numbers[count++] = pick;
                    numberCheck[pick] = true;
                }
            } while (count < BALL_LENGTH);
            return numbers;
        }

        private Boolean countStrike(GameResult gameResult, int ballOneValue, int ballTwoValue){
            if (ballOneValue == ballTwoValue) {
                gameResult.addStrike();
                return true;
            }
            return false;
        }

        private void countBall(GameResult gameResult, int compareValue){
            if (this.checkValueIsExist(compareValue)) {
                gameResult.addBall();
            }
        }

        public Boolean checkValueIsExist(int value){
            return this.ballExists[value];
        }

        private void markValueExist() {
            Arrays.fill(this.ballExists, false);
            for (int i=0 ; i<BALL_LENGTH ; i++){
                this.ballExists[this.ballValues[i]] = true;
            }
        }

    }
