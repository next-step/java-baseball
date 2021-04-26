import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputNumber {

    private List<Integer> inputNumber;

    public List<Integer> InputNumber() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            this.inputNumber = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = scan.nextLine();
            try {
                this.inputNumber = validation(inputString);
                break;
            } catch (RuntimeException e) {
            }
        }
        return this.inputNumber;
    }

    public List<Integer> validation(String stringNumber) {
        if (stringNumber.length() != 3) {
            System.out.println("3자리 숫자를 입력해주세요.");
            throw new RuntimeException("3자리 숫자를 입력해주세요.");
        }
        return doubleCheck(charToInt(stringNumber));
    }

    public List<Integer> charToInt(String stringNumber) {
        for (int i = 0; i < 3; i++) {
            inputNumber.add(getInt(stringNumber.charAt(i)));
        }
        return inputNumber;
    }

    public int getInt(char charNumber) {
        int number = Character.getNumericValue(charNumber);
        if (number < 1 || number > 9) {
            System.out.println("입력 숫자를 확인해주세요.");
            throw new RuntimeException("입력한 숫자를 확인해주세요.");
        }
        return number;
    }

    public List<Integer> doubleCheck(List<Integer> inputNumber) {
        for (int i = 0; i < inputNumber.size(); i++) {
            int checkNumber = inputNumber.get(i);
            inputNumber.set(i, 0);
            doDoubleCheck(inputNumber, checkNumber, i);
        }
        return this.inputNumber;
    }

    private List<Integer> doDoubleCheck(List<Integer> inputNumber, int checkNumber, int count) {
        if (inputNumber.contains(checkNumber)) {
            System.out.println("중복된 숫자를 입력하였습니다.");
            throw new RuntimeException("중복된 숫자를 입력하였습니다.");
        }
        inputNumber.set(count, checkNumber);
        return inputNumber;
    }
}
