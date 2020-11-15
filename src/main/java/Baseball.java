import java.util.*;

public class Baseball {
    Scanner scanner = new Scanner(System.in);
    private List<String> userNumbers;

    public void gamePlay() {
        Computer computer = new Computer();
        computer.generateNumber();

        userNumberInput();

        gameEnd();
    }


    public void userNumberInput() {

        System.out.print("숫자를 입력해주세요: ");
        Set<String> userNumberSet = new LinkedHashSet<>(Arrays.asList(scanner.next().split("")));

        while (userNumberSet.size() != 3) {
            System.out.print("잘못된 입력입니다. 서로 다른 1~9의 3자리 숫자를 입력해주세요: ");
            userNumberSet = new LinkedHashSet<>(Arrays.asList(scanner.next().split("")));
        }

        userNumbers = new ArrayList<>(userNumberSet);
    }

    public void gameEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        if (scanner.nextInt() == 2) {
            return;
        }
        gamePlay();
    }

    public List<String> getUserNumbers() {
        return userNumbers;
    }
}
