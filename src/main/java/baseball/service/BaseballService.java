package baseball.service;

import java.util.*;

public class BaseballService {
    private static final int BALL_COUNT = 3;
    private static final int MAX_BALL_NUM = 9;
    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;

    private static int[] computerNums;
    private static int[] inputNums;
    private static Scanner sc;
    private boolean isContinue = true;

    public BaseballService() {
        computerNums = new int[BALL_COUNT];
        inputNums = new int[BALL_COUNT];
        sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("게임이 시작 되었습니다.");
        while (isContinue) {
            init();
            play();
        }
        System.out.println("게임이 종료 되었습니다.");
    }

    private void init() {
        initComputerNums();
        setComputerNums();
        isContinue = true;
    }

    private void play() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            divideInputNum(getInputNum());
        } while (checkNums(compareNums()));
    }

    private void setComputerNums() {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < BALL_COUNT; i++) {
            computerNums[i] = getUniqueNum(set);
        }
        System.out.print("computerNums = ");
        for (int n : computerNums) {
            System.out.print(n);
        }
        System.out.println();
    }

    private String getInputNum() {
        return sc.next();
    }

    public int[] divideInputNum(String strNum) {
        for (int i = 0; i < strNum.length(); i++) {
            inputNums[i] = strNum.charAt(i) - '0';
        }
        return inputNums;
    }

    private int[] compareNums() {
        int[] compareNums = new int[BALL_COUNT];

        for (int i = 0; i < BALL_COUNT; i++) {
            for (int j = 0; j < BALL_COUNT; j++) {
                compareNums[getCmpIndex(i, j)]++;
            }
        }
        return compareNums;
    }

    private boolean checkNums(int[] compareNums) {
        if (isAllMatch(compareNums)) {
            setContinueValue();
            return false;
        }
        if (isNotAllMatch(compareNums)) {
            System.out.println("낫싱");
        }
        if (isAnyMatch(compareNums)) {
            printResult(compareNums);
        }
        return true;
    }

    private void setContinueValue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNum = Integer.parseInt(getInputNum());

        while (inputNum != GAME_RESTART && inputNum != GAME_END) {
            inputNum = Integer.parseInt(getInputNum());
        }
        if (inputNum == GAME_END) {
            isContinue = false;
        }
    }

    public int getUniqueNum(Set<Integer> set) {
        while (true) {
            int num = makeNum();

            if (!set.contains(num)) {
                set.add(num);
                return num;
            }
        }
    }

    private void initComputerNums() {
        Arrays.fill(computerNums, -1);
    }

    private int makeNum() {
        return new Random().nextInt(MAX_BALL_NUM) + 1;
    }

    private int getCmpIndex(int computerIndex, int inputIndex) {
        if (computerNums[computerIndex] == inputNums[inputIndex]) {
            if (computerIndex == inputIndex) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    public boolean isAllMatch(int[] compareNums) {
        return compareNums[0] == 3;
    }

    public boolean isNotAllMatch(int[] compareNums) {
        return compareNums[0] == 0 && compareNums[1] == 0;
    }

    public boolean isAnyMatch(int[] compareNums) {
        return compareNums[0] != 0 || compareNums[1] != 0;
    }

    private void printResult(int[] compareNums) {
        StringBuffer sb = new StringBuffer();

        if (compareNums[0] > 0) {
            sb.append(compareNums[0]).append(" 스트라이크 ");
        }
        if (compareNums[1] > 0) {
            sb.append(compareNums[1]).append(" 볼 ");
        }

        System.out.println(sb);
    }
}
