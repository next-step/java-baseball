package me.totoku103.baseball;

import java.util.Random;

public class Computer {
    private boolean isDuplication(String digitString, int number) {
        if (digitString.length() == 0) return false;
        return digitString.contains(String.valueOf(number));
    }

    private int generateRandomNumber(int min, int max) {
        if (min <= 0 || 10 <= min) throw new IllegalArgumentException(String.format("possible number range(1~9). min(%d)", min));
        if (max <= 0 || 10 <= max) throw new IllegalArgumentException(String.format("possible number range(1~9). max(%d)", max));
        if (min > max) throw new IllegalArgumentException(String.format("wrong input value. min(%d) > max(%d)", min, max));

        return new Random().nextInt(((max + 1) - min)) + min;
    }

    public String generateRandomDigitString(int min, int max, int size) {
        StringBuffer sb = new StringBuffer();
        for (; sb.length() < size; ) {
            final int randomNumber = this.generateRandomNumber(min, max);
            if (!isDuplication(sb.toString(), randomNumber)) sb.append(randomNumber);
        }
        return sb.toString();
    }
}
