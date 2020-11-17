import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    private static boolean islive = true;
    private static String message = "";
    private static int[] right_answer;
    private static int strike = 0;
    private static int ball = 0;

    public void start() {
        this.gameInit();

        while (islive) {
            this.resetStrikeBall();
            System.out.print(Arrays.deepToString(new int[][]{right_answer}));
            String input = this.getInput();
            this.check(input);
        }
    }

    /**
     * 게임 만들기
     */
    private void gameInit() {
        this.right_answer = this.createAnswerArray();
    }

    /**
     * 스트라이크,볼 초기화
     */
    private void resetStrikeBall() {
        this.strike = 0;
        this.ball = 0;
    }

    /**
     * 정답 만들기
     * @return
     */
    private int[] createAnswerArray() {
        // todo 중복 번호 없게 수정해야함
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = this.getRandomNum();
        }
        return answer;
    }

    /**
     * 랜덤 번호 가져오기 0-8
     * @return
     */
    private int getRandomNum() {
        double random = Math.random();
        int random_idx = (int)(random * 8);

        return random_idx;
    }

    /**
     * 입력값 int 배열로 만들기
     * @param input
     * @return
     */
    private int[] makeArray(String input) {
        int[] result = new int[3];

        for (int i = 0; i < input.length() ; i++) {
            result[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return result;
    }

    /**
     * 메시지 보내기
     * @param message
     */
    private void message(String message, boolean islive) {
        System.out.println(message);
        this.islive = islive;
    }

    /**
     * 게임 판정
     * @param input
     */
    private void check(String input) {
        if(!this.isNumber(input) || !this.checkInputThreeLength(input)) {
            this.message(message,true);
        }
        int[] input_array = this.makeArray(input);
        this.checkAnswer(input_array);
    }

    /**
     * 체크한 스트라이크,볼 메시지 보내기
     */
    private void checkStrikeBallMessage() {
        String message = "";
        if (strike > 0) {
            message += strike + " 스트라이크 ";
        }

        if (ball > 0) {
            message += ball + " 볼";
        }

        if (message.length() > 0) {
            this.message(message, true);
        }
    }

    /**
     * 스트라이크와 볼 체크
     * @param input_num         입력숫자
     * @param input_idx         입력숫자 자릿수
     * @param right_answer_num  정답숫자
     * @param right_answer_idx  정답숫자 자릿수
     */
    private void checkStrikeBall(int input_num, int input_idx, int right_answer_num, int right_answer_idx) {
        if (input_num == right_answer_num && input_idx == right_answer_idx) {
            strike++;
        }

        if (input_num == right_answer_num && input_idx != right_answer_idx) {
            ball++;
        }
    }

    /**
     * 숫자 검증
     * @param input_num
     * @param input_idx
     */
    private void checkNumber(int input_num, int input_idx) {
        for (int i = 0; i < right_answer.length; i++) {
            this.checkStrikeBall(input_num, input_idx, right_answer[i] , i);
        }
    }

    /**
     * 정답 검증
     * @param input_array
     */
    private void checkAnswer(int[] input_array) {
        for (int i = 0; i < input_array.length; i++) {
            this.checkNumber(input_array[i], i);
        }

        this.checkStrikeBallMessage();

        if (strike == 3) {
            this.message("3개의 숫자를 모두 맞히셨습니다. 게임종료", false);
       }
    }

    /**
     * 입력값 받아오기
     * @return
     */
    private String getInput() {
        this.message("숫자를 입력해 주세요 : ", true);
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        return input;
    }

    /**
     * 입력값이 3자리인지 검증
     * @param input 입력값
     * @return
     */
    private boolean checkInputThreeLength(String input) {
        if (input.length() != 3) {
            message = "숫자 3자리를 입력해주세요.";
            return false;
        }
        return true;
    }

    /**
     * 입력값 숫자 체크
     * @param input
     * @return
     */
    private boolean isNumber(String input) {
        message = "숫자만 입력가능합니다.";
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
