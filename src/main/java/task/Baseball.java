package task;

import java.util.*;

public class Baseball {

    final Set<Integer> computer;
    Random random;
    final int COLLECTION_MAXIMUM_LENGTH = 3;
    final List<Integer> user;
    int strike = 0;
    int ball = 0;

    Scanner scanner;

    public Baseball() {
        computer = new HashSet<>();
        random = new Random();
        user = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    void computerNumberInput() {
        while(computer.size() < COLLECTION_MAXIMUM_LENGTH)
            computer.add(random.nextInt(10)+1);
    }

    void userGameNumberInput() {
        while(user.size() < COLLECTION_MAXIMUM_LENGTH)
            user.add(scannerIntInput());
    }

    int scannerIntInput() {
        return scanner.nextInt();
    }

    void compare() {
        Iterator<Integer> userIter = user.iterator();
        for(Integer number : computer) {
            strikeBallCheck(number, userIter.next());
        }
    }

    void strikeBallCheck(Integer computer, Integer user) {
        if(computer.equals(user)) {
            strike += 1;
            return;
        }
        if(this.user.contains(computer)) {
            ball += 1;
        }
    }

    void resultOutput() {
        if(strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        if(strike == 0 && ball > 0)
            System.out.println(ball+" 볼");
        if(strike > 0 && ball == 0)
            System.out.println(strike+" 스트라이크");
        if(strike > 0 && ball > 0)
            System.out.println(strike+" 스트라이크 " + ball+" 볼");
        if(strike == 0 && ball == 0)
            System.out.println("낫싱");
    }

    void answer() {
        if(strike == 3) {
            resultOutput();
            restartOrExit();
            return;
        }
        resultOutput();
        userCollectionClear();
    }

    void restartOrExit() {
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요");
        int answer = scannerIntInput();
        if(answer == 1) {
            gameRestart();
            return;
        }
        if(answer == 2) {
            scannerClose();
        }
    }

    void gameRestart() {
        numberInitialize();
        computerCollectionClear();
        userCollectionClear();
        computerNumberInput();
        computerArrayOutput();
    }

    public void gameStart() {
        computerNumberInput();
        computerArrayOutput();

        while(strike != 3) {
            numberInitialize();
            userGameNumberInput();
            System.out.println("사용자 입력 값 : " + Arrays.toString(user.toArray()));
            compare();
            answer();
        }
    }

    void computerArrayOutput() {
        System.out.println("컴퓨터 값 : " + Arrays.toString(computer.toArray()));
    }

    void numberInitialize() {
        strike = 0;
        ball = 0;
    }

    void userCollectionClear() {
        user.clear();
    }

    void computerCollectionClear() {
        computer.clear();
    }

    void scannerClose() {
        scanner.close();
    }

}
