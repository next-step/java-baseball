package com.tjnam.baseballgame;

import java.util.Arrays;

    public class Balls {
        final int BALL_LENGTH = 3;
        final int BALL_RANGE = 10;
        private int[] ballValues;


        public Balls(){
            this.ballValues = new int[BALL_LENGTH];
        }

        public Balls(int[] selection) {
            this.ballValues = new int[BALL_LENGTH];
        }

        public void SetRandomBalls() {
            int[] randomBalls = this.getRandomNumbers();
            this.setBallValues(randomBalls);
        }

        public void setBallValues(int[] selection) {
            this.ballValues = selection;
        }

        public int[] getNumbers(){
            return this.ballValues;
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
    }
