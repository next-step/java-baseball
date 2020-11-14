package component;

import model.ThreeDigits;

import java.util.*;

public class AnswerCreator {
    private AnswerCreator() {
    }

    static public ThreeDigits createAnswer() {
        Iterator<Integer> iterator = new ShuffledUniqueRandomNumbers(1, 9)
                .iterator();

        StringBuilder stringBuilder = new StringBuilder();

        for (int count = 1; count <= 3; count++) {
            stringBuilder.append(iterator.next());
        }

        return ThreeDigits.createFrom(stringBuilder.toString());
    }

    private static class ShuffledUniqueRandomNumbers implements Iterable<Integer> {
        private final static Random RANDOM = new Random();

        private final Integer[] numbers;

        public ShuffledUniqueRandomNumbers(int minNumber, int maxNumber) {
            this.numbers = new Integer [(maxNumber - minNumber) + 1];

            for (int index = 0, number = minNumber; number <= maxNumber; index++, number++) {
                numbers[index] = number;
            }

            int shuffleTimes = numbers.length / 2;
            shuffle(shuffleTimes);
        }

        @Override
        public Iterator<Integer> iterator() {
            return Arrays
                    .asList(numbers)
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
