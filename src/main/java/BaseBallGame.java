import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    private int cnt = 3;

    public void main(String[] args) throws Exception {
        int[] answer = new int[cnt];
        int status = 1; //1 : (재)시작, 2 : 종료
        setNumber();
        inputNumber();
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

}
