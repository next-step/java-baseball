package baseball;

import java.util.Scanner;

class Pitcher {
    private int baseBallNumberLength;

    Pitcher(int baseBallNumberLength) {
        this.baseBallNumberLength = baseBallNumberLength;
    }

    public int[] getPitchingNumber() {
        int[] pitchingNumbers = new int[baseBallNumberLength];

        System.out.print("숫자를 입력해주세요:");
        Scanner scanner = new Scanner(System.in);
        int pitchingNumber = scanner.nextInt();
        char[] pitchingChars = Integer.toString(pitchingNumber).toCharArray();

        for (int i = 0; i < baseBallNumberLength; i++) {
            pitchingNumbers[i] = Character.getNumericValue(pitchingChars[i]);
        }

        return pitchingNumbers;
    }
}