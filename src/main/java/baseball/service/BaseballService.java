package baseball.service;

import java.util.*;

public class BaseballService {
    private static final int BALL_COUNT = 3;
    private static final int MAX_RANGE_NUM = 10;
    private static int[] computerNums;
    private static int[] inputNums;
    private static Scanner sc;

    public BaseballService() {
        computerNums = new int[BALL_COUNT];
        inputNums = new int[BALL_COUNT];
        sc = new Scanner(System.in);
    }

    public void start() {
        setComputerNums();
        System.out.print("숫자를 입력해주세요 : ");
        divideInputNum(getInputNum());
    }

    private void setComputerNums() {
        initComputerNums();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < BALL_COUNT; i++) {
            computerNums[i] = getUniqueNum(set);
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
        return new Random().nextInt(MAX_RANGE_NUM);
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
}
