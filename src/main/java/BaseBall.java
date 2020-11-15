import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {
    final int MAX_NUMBER = 3;
    Set<Integer> numberSet = new HashSet<>();
    int[] computerNumbers = new int[MAX_NUMBER];
    int[] playerNumbers = new int[MAX_NUMBER];

    public int generateRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    public void insertDifferentNumbers(int number) {
        if(numberSet.add(number)){
            computerNumbers[numberSet.size() - 1] = number;
        }
    }

    public void inputView() {
        System.out.print("숫자를 입력해주세요 : ");
        insertInputNumber(inputNumber());
    }

    public int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void insertInputNumber(int enteredNumber) {
        int index = MAX_NUMBER - 1;
        while(enteredNumber > 0) {
            playerNumbers[index] = enteredNumber % 10;
            enteredNumber /= 10;
            index--;
        }
    }
}
