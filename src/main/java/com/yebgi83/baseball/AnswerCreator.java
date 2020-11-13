package com.yebgi83.baseball;

import java.util.*;

public class AnswerCreator {
    public ThreeDigits createAnswer() {
        Iterator<Integer> iterator = new UniqueRandomNumbers(1, 9)
                .iterator();

        StringBuilder stringBuilder = new StringBuilder();

        for (int count = 1; count <= 3; count++) {
            stringBuilder.append(iterator.next());
        }

        return ThreeDigits.createFromString(stringBuilder.toString());
    }

    private static class UniqueRandomNumbers implements Iterable<Integer> {
        private final static Random RANDOM = new Random();

        private final int[] numbers;

        public UniqueRandomNumbers(int minNumber, int maxNumber) {
            this.numbers = new int [(maxNumber - minNumber) + 1];

            for (int index = 0, number = minNumber; number <= maxNumber; index++, number++) {
                numbers[index] = number;
            }

            int shuffleTimes = numbers.length / 2;
            shuffle(shuffleTimes);
        }

        @Override
        public Iterator<Integer> iterator() {
            return Arrays
                    .stream(numbers)
                    .iterator();
        }

        private void shuffle(int times) {
            for (int trial = 1; trial <= times; trial++) {
                int firstIndex = RANDOM.nextInt(numbers.length);
                int secondIndex = RANDOM.nextInt(numbers.length);

                swap(firstIndex, secondIndex);
            }
        }

        private void swap(int firstIndex, int secondIndex) {
            int temp = numbers[firstIndex];

            numbers[firstIndex] = numbers[secondIndex];
            numbers[secondIndex] = temp;
        }
    }
}
