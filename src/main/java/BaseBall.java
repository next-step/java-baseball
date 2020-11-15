import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {
    final int MAX_NUMBER = 3;
    Set<Integer> numberSet = new HashSet<>();
    int[] computerNumbers = new int[MAX_NUMBER];
    int[] playerNumbers = new int[MAX_NUMBER];
    int strike = 0;
    int ball = 0;
    int end = 0;

    public int generateRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    public void insertDifferentNumbers(int number) {
        if (numberSet.add(number)) {
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
        while (enteredNumber > 0) {
            playerNumbers[index] = enteredNumber % 10;
            enteredNumber /= 10;
            index--;
        }
    }

    public void compareNumbers(int i, int j) {
        if (j > 2) {
            return;
        }
        if (i == j && computerNumbers[i] == playerNumbers[j]) {
            strike++;
        }
        if (i != j && computerNumbers[i] == playerNumbers[j]) {
            ball++;
        }
        compareNumbers(i, ++j);
    }

    public void repeatComparing() {
        initUser();
        inputView();
        for (int i = 0; i < MAX_NUMBER; i++) {
            compareNumbers(i,0);
        }
        System.out.println(getHintMessage());
    }

    public void initUser() {
        strike = 0;
        ball = 0;
    }

    public String getHintMessage() {
        String message = "";
        if (strike == MAX_NUMBER){
            end++;
            return "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike > 0) {
            message += strike + " 스트라이크 ";
        }
        if (ball > 0) {
            message += ball + " 볼";
        }
        return message;
    }

    public void play() {
        while (numberSet.size() < MAX_NUMBER) {
            insertDifferentNumbers(generateRandomNumber());
        }

        while (end < 1) {
            repeatComparing();
        }

        System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        int enteredNumber = inputNumber();
        if(enteredNumber == 1) {
            initComputer();
            play();
        }
    }

    public void initComputer() {
        numberSet = new HashSet<>();
        end = 0;
    }
}
