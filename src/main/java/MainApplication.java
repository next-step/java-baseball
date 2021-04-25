import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MainApplication {

  public static void main(String[] args) {
    MainApplication mainApplication = new MainApplication();

    List<Character> randomNumber = null;
    boolean exit = false;
    boolean newGame = true;

    Scanner scanner = new Scanner(System.in);
    while (!exit) {
      if (newGame) {
        randomNumber = mainApplication.generateRandomNumber(3);
        newGame = false;
      }

      System.out.print("숫자를 입력해주세요 : ");
      List<Character> inputNumber = mainApplication.convertToList(scanner.nextLine().toCharArray());

      if (!mainApplication.validateInputNumber(inputNumber)) {
        System.out.println("중복 되지 않은 1~9까지의 3자리 숫자를 입력해주세요.");
        continue;
      }

      List<Character> tempRandomNumber = new LinkedList<>(randomNumber);

      int strike = mainApplication.validateStrike(tempRandomNumber, inputNumber);
      int ball = mainApplication.validateBall(tempRandomNumber, inputNumber);
      mainApplication.printResult(strike, ball);

      if (strike == 3) {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        exit = !mainApplication.checkRestartGame();
        newGame = exit;
      }
    }
  }

  // 입력값 검증
  public boolean validateInputNumber(List<Character> inputNumber) {
    Set<Character> characterSet = new HashSet<>(inputNumber);

    if (characterSet.contains('0')) {
      return false;
    }

    return characterSet.size() == 3;
  }

  // Convert char array to Character List
  public List<Character> convertToList(char[] chars) {
    List<Character> characterList = new LinkedList<>();
    for (char c : chars) {
      characterList.add(c);
    }
    return characterList;
  }

  // 난수 생성
  public List<Character> generateRandomNumber(int length) {
    List<Character> numbers =
        new LinkedList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    Random random = new Random();
    List<Character> randomNumber = new LinkedList<>();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(numbers.size() - 1);
      randomNumber.add(numbers.get(index));
      numbers.remove(index);
    }

    return randomNumber;
  }

  // Strike 확인
  public int validateStrike(List<Character> randomNumber, List<Character> inputNumber) {
    int strike = 0;
    int size = randomNumber.size();
    for (int i = 0; i < size; i++) {
      if (randomNumber.get(i) == inputNumber.get(i)) {
        strike++;
        randomNumber.remove(i);
        inputNumber.remove(i);
        size = randomNumber.size();
        i--;
      }
    }

    return strike;
  }

  // Ball 확인
  public int validateBall(List<Character> randomNumber, List<Character> inputNumber) {
    int ball = 0;
    for (int i = 0; i < randomNumber.size(); i++) {
      if (randomNumber.contains(inputNumber.get(i))) {
        ball++;
      }
    }

    return ball;
  }

  // 결과 출력
  public void printResult(int strike, int ball) {
    if (strike > 0) {
      System.out.print(strike + " 스트라이크 ");
    }

    if (ball > 0) {
      System.out.print(ball + " 볼");
    }

    if (strike == 0 && ball == 0) {
      System.out.print("4 볼");
    }

    System.out.println();
  }

  // 다시 시작 여부 확인
  public boolean checkRestartGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요.");
    int input = scanner.nextInt();

    return input == 1;
  }
}
