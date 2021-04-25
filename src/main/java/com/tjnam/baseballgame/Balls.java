package com.tjnam.baseballgame;

import java.util.Arrays;

    public class Balls {
        final int BALL_LENGTH = 3;
        final int BALL_RANGE = 10;
        private int[] ballValues;
        private Boolean[] ballExists;


        public Balls(){
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
            Arrays.fill(this.ballExists, false);
        }

        public Balls(int[] selection) {
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
            Arrays.fill(this.ballExists, false);
        }

        public Balls(String numbers) {
            this.ballValues = new int[BALL_LENGTH];
            this.ballExists = new Boolean[BALL_RANGE];
            Arrays.fill(this.ballExists, false);
            this.setBallValues(numbers);
        }

        public void setRandomBalls() {
            int[] randomBalls = this.getRandomNumbers();
            this.setBallValues(randomBalls);
        }

        public void setBallValues(int[] selection) {
            this.ballValues = selection;
        }

        public void setBallValues(String numbers) {
            this.ballValues[0] = Integer.parseInt(String.valueOf(numbers.charAt(0)));
            this.ballValues[1] = Integer.parseInt(String.valueOf(numbers.charAt(1)));
            this.ballValues[2] = Integer.parseInt(String.valueOf(numbers.charAt(2)));
        }

        public int[] getNumbers(){
            return this.ballValues;
        }

        public GameResult compareBalls(Balls compareTarget){
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
            int numbers[] = new int[BALL_LENGTH];
            boolean numberCheck[] = new boolean[BALL_RANGE];

            do {
                int pick = (((int) (Math.random() * 10)) % 9) + 1;

                if (numberCheck[pick] == false) {
                    numbers[numbers.length] = pick;
                    numberCheck[pick] = true;
                }
            } while (numbers.length < BALL_LENGTH);

            return numbers;
        }

        private Boolean countStrike(GameResult gameResult, int ballOneValue, int ballTwoValue){
            if (ballOneValue == ballTwoValue) {
                gameResult.addStrike();
                return true;
            }
            return false;
        }

        private Boolean countBall(GameResult gameResult, int compareValue){
            if (this.checkValueIsExist(compareValue)) {
                gameResult.addBall();
                return true;
            }
            return false;
        }


        public Boolean checkValueIsExist(int value){
            return this.ballExists[value];
        }

    }
