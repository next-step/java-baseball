import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class GameHost {
    private Integer[] threeNumGeneratedByComputer;
    private Integer[] threeNumEnteredByPlayer;
    private int strike;
    private int ball;

    public static void main(String[] args) {
        GameHost host = new GameHost();
        host.playGame();
    }

    public void playGame() {
        generateRandThreeNum();
        initializePlayerVariable();
        enterPlayersThreeNum();
        compareComputerAndPlayer();
    }

    private void initializePlayerVariable() {
        threeNumEnteredByPlayer = new Integer[3];
        strike = 0;
        ball = 0;
    }

    private void generateRandThreeNum() {
        threeNumGeneratedByComputer = new Integer[3];
        HashSet<Integer> randNumDeduplicated = new HashSet<>();
        Random randInstance = new Random();

        while (randNumDeduplicated.size() < 3) {
            randNumDeduplicated.add(randInstance.nextInt(9) + 1);
        }
        randNumDeduplicated.toArray(threeNumGeneratedByComputer);
    }

    private void enterPlayersThreeNum() {
        Scanner scanner = new Scanner(System.in);
        String enteredNum;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            enteredNum = scanner.nextLine();
        } while (!isValid(enteredNum));
        setPlayersNumArrFrom(enteredNum);
    }

    private boolean isValid(String numberStr) {
        return (numberStr.length() == 3 && numberStr.matches("^[1-9]*$")
                && isUniqueEach(numberStr));
    }

    private boolean isUniqueEach(String numberStr) {
        HashSet<Character> uniqueNumber = new HashSet<>();

        for (int i = 0; i < numberStr.length(); i++) {
            uniqueNumber.add(numberStr.charAt(i));
        }

        return (uniqueNumber.size() == numberStr.length());
    }

    private void setPlayersNumArrFrom(String numberStr) {
        for (int i = 0; i < numberStr.length(); i++) {
            threeNumEnteredByPlayer[i] = numberStr.charAt(i) - '0';
        }
    }

    private void compareComputerAndPlayer() {
        for (int pickedPlayerIdx = 0; pickedPlayerIdx < 3; pickedPlayerIdx++) {
            matchAllComputerIdxWithOnePlayerIdx(pickedPlayerIdx);
        }
    }

    private void matchAllComputerIdxWithOnePlayerIdx(int playerIdx) {
        for (int pickedComputerIdx = 0; pickedComputerIdx < 3; pickedComputerIdx++) {
            compareValWithTwoIdx(playerIdx, pickedComputerIdx);
        }
    }

    private void compareValWithTwoIdx(int playerIdx, int computerIdx) {
        if (threeNumEnteredByPlayer[playerIdx] != threeNumGeneratedByComputer[computerIdx]) {
            return;
        }
        if (playerIdx == computerIdx) {
            strike++;
            return;
        }
        ball++;
    }
}
