import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Baseball {
    Scanner scanner = new Scanner(System.in);
    private Set<String> userNumberSet;

    public void gamePlay() {
        Computer computer = new Computer();
        computer.generateNumber();

        userNumberInput();

        gameEnd();
    }


    public void userNumberInput() {

        System.out.println("숫자를 입력해주세요: ");
        String[] inputNumbers = scanner.next().split("");
        userNumberSet = new LinkedHashSet<>(Arrays.asList(inputNumbers));

        while (userNumberSet.size() != 3) {
            System.out.println("잘못된 입력입니다. 중복없는 1~9의 3자리 숫자를 입력해주세요: ");
            inputNumbers = scanner.next().split("");
            userNumberSet = new LinkedHashSet<>(Arrays.asList(inputNumbers));
        }
    }

    public void gameEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (scanner.nextInt() == 2) {
            return;
        }
        gamePlay();
    }

    public Set<String> getUserNumberSet(){
        return userNumberSet;
    }

}
