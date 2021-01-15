import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

public class NumberBaseball {
    Scanner sc = new Scanner(System.in);
    String computerNumber;
    String userNumber;
    int strike;
    int ball;

    public void startGame() {
        int gameStart = 1;
        while (gameStart == 1){
        this.resetGame();

        this.playGame();

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameStart = sc.nextInt();
        }
    }

    private void resetGame() {
        int[] numbers = new int[3];
        int result = 0;
        Random rand = new Random();

        numbers[0] = rand.nextInt(9)+1;
        result += numbers[0]*100;

        numbers[1] = rand.nextInt(9)+1;
        while (numbers[0] == numbers[1]) {
            numbers[1] = rand.nextInt(9)+1;
        }
        result += numbers[1]*10;

        numbers[2] = rand.nextInt(9)+1;
        while (numbers[0] == numbers[2] || numbers[1] == numbers[2]) {
            numbers[2] = rand.nextInt(9)+1;
        }
        result += numbers[2];

        computerNumber = String.valueOf(result);
    }

    private void playGame() {
        while (true) {
            strike=0;
            ball=0;

            this.getUserNumber();

            this.checkResult();

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
            } else if (ball != 0 && strike != 0) {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            } else if (ball != 0 && strike == 0) {
                System.out.println(ball+"볼");
            } else if (ball == 0 && strike != 0) {
                System.out.println(strike+"스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    private void getUserNumber() {
        while (true) {
            System.out.println("숫자를 입력해 주세요 : ");
            userNumber = sc.next();

            if (this.checkAvailable()) {
                return;
            } else {
                System.out.println("올바른 숫자를 입력해주세요.");
            }
        }
    }

    private Boolean checkAvailable() {
        Set<Integer> hash_Set = new HashSet<Integer>();
        for (int i=0; i<3; i++) {
            if (Character.isDigit(userNumber.charAt(i)) == false) {
                return false;
            }
            int nowNumber = Integer.valueOf(userNumber.substring(i, i+1));
            if (1 <= nowNumber && nowNumber <= 9) {
                hash_Set.add(nowNumber);
            }
        }
        return hash_Set.size() == 3;
    }

    private void checkResult() {
        for (int i=0; i<3; i++) {
            int idx = computerNumber.indexOf(userNumber.charAt(i));
            if (idx == i) {
                strike += 1;
            } else if (idx != -1) {
                ball += 1;
            }
        }
    }
}
