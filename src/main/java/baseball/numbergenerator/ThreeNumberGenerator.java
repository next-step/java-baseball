package baseball.numbergenerator;

import utils.RandomUtils;

public class ThreeNumberGenerator implements NumberGenerator {

    @Override
    public String create() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffling(numbers);
        return getThreeNumbersFrom(numbers);
    }

    private String getThreeNumbersFrom(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    private void shuffling(int[] numbers) {
        int temp = 0, j = 0;
        for (int i = 0; i < 50; i++) {
            j = RandomUtils.nextInt(0, 8);
            temp = numbers[0];
            numbers[0] = numbers[j];
            numbers[j] = temp;
        }
    }
}
