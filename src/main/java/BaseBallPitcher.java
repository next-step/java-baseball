import java.util.Scanner;

class BaseBallPitcher {
    private int baseBallNumberLength;

    BaseBallPitcher(int baseBallNumberLength) {
        this.baseBallNumberLength = baseBallNumberLength;
    }

    public int[] getPitchingNumber() {
        int[] pitchingNumbers = new int[baseBallNumberLength];

        System.out.print("숫자를 입력해주세요:");
        Scanner scanner = new Scanner(System.in);
        int pitchingNumber = scanner.nextInt();
        char[] pitchingChars = Integer.toString(pitchingNumber).toCharArray();

        for (char pitchingChar : pitchingChars) {
            Character.getNumericValue(pitchingChar);
        }

        return pitchingNumbers;
    }
}