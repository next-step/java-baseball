import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    private int cnt = 3;

    public void main(String[] args) throws Exception {
        int[] answer = new int[cnt];
        int status = 1; //1 : (재)시작, 2 : 종료, 3 : 진행중

        while (status != 2) {
            if (status == 1) answer = setNumber();
            status = execution(inputNumber(), answer);
            if (status == 2) status = isExit();
        }
    }

    /**
     * 컴퓨터가 서로 다른 임의의 수 3개 선택.
     * @return int[]
     */
    public int[] setNumber() {
        int[] answer = new int[cnt];
        Random random = new Random();
        while (true) {
            answer[0] = random.nextInt(10);
            answer[1] = random.nextInt(10);
            answer[2] = random.nextInt(10);
            if (answer[0] != answer[1] && answer[0] != answer[2] && answer[1] != answer[2]) break;
        }
        return answer;
    }

    /**
     * 유저가 임의의 수 3개 선택.
     * @return int[]
     */
    public int[] inputNumber() throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = "";
        int[] inputNumbers = new int[cnt];
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = sc.nextLine();
            if (checkNumber(input)) break;
        }
        for (int i = 0; i < cnt; i++) { inputNumbers[i] = input.charAt(i) - '0'; }
        return inputNumbers;
    }

    /**
     * 입력값 확인
     * @param input
     * @return boolean
     */
    public boolean checkNumber(String input) {
        if (input.length() != cnt) return false;
        char[] charArr = input.toCharArray();
        for (char c : charArr) {
            if (c > '9' || c < '0') return false;
        }
        return true;
    }

    /**
     * 유저의 답과 정답을 비교 후 결과 반환. (2 : 종료, 3 : 진행중)
     * @param inputNumbers
     * @param answer
     * @return int
     */
    public int execution(int[] inputNumbers, int[] answer) {
        int strikeCnt = 0;
        int ballCnt = 0;
        int nothingCnt = 0;

        for (int i = 0; i < cnt; i++) {
            System.out.println("num : " + inputNumbers[i]);
            strikeCnt += isStrike(i, inputNumbers[i], answer);
            ballCnt += isBall(i, inputNumbers[i], answer);
            nothingCnt += isNothing(inputNumbers[i], answer);
        }

        if (strikeCnt != 0) System.out.printf("%d 스트라이크 ", strikeCnt);
        if (ballCnt != 0) System.out.printf("%d 볼 ", ballCnt);
        if (nothingCnt == cnt) System.out.print("4 볼");
        System.out.println();

        return (strikeCnt == cnt) ? 2 : 3;
    }

    /**
     * Strike 확인 (0 : Ball or Nothing, 1 : Strike)
     *
     * @param index
     * @param num
     * @param answer
     * @return int
     */
    public int isStrike(int index, int num, int[] answer) {
        if (num == answer[index]) return 1;
        return 0;
    }

    /**
     * Ball 확인 (0 : Strike or Nothing, 1 : Ball)
     *
     * @param index
     * @param num
     * @param answer
     * @return int
     */
    public int isBall(int index, int num, int[] answer) {
        boolean result = false;
        for (int i = 0; i < cnt; i++) {
            if (i != index && num == answer[i]) result = true;
        }
        return result ? 1 : 0;
    }

    /**
     * Nothing 확인 (0 : Strike or Ball, 1 : Nothing)
     *
     * @param num
     * @param answer
     * @return int
     */
    public int isNothing(int num, int[] answer) {
        boolean result = true;
        for (int i = 0; i < cnt; i++) {
            if (num == answer[i]) result = false;
        }
        return result ? 1 : 0;
    }

    /**
     * 게임 종료 확인 (1 : (재)시작, 2 : 종료)
     * @return int
     */
    private static int isExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return 2;
    }
}
