import java.util.Scanner;

public class UserInputNumber {

    private int[] inputNumber;

    public int[] InputNumber() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = scan.nextLine();
            try {
                inputNumber = validation(inputString);
                break;
            } catch (RuntimeException e) {
            }
        }
        return inputNumber;
    }

    private int[] validation(String inputNumber) {
        if (inputNumber.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요.");
            throw new RuntimeException("3자리 숫자를 입력해주세요.");
        }
        return charToInt(inputNumber);
    }

    private int[] charToInt(String inputNumber) {
        int[] charNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            charNumber[i] = checkRange(inputNumber.charAt(i));
        }
        return charNumber;
    }

    private int checkRange(char charNumber) {
        int number = Character.getNumericValue(charNumber);
        if (number < 1 || number > 9) {
            System.out.println("입력 숫자를 확인해주세요.");
            throw new RuntimeException("입력 숫자를 확인해주세요.");
        }
        return number;
    }
}
