import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseBallGame {
    enum Status {
        PROGRESS, SUCCESS, EXIT
    }

    enum Select {
        RESTART("1"),
        EXIT("2")
        ;

        private final String response;

        Select(String response) {
            this.response = response;
        }

        public boolean isSelected(String choice) {
            return response.equals(choice);
        }
    }

    private static final String EMPTY_STRING = "";

    private final BufferedReader br;
    private Computer computer;
    private Status status;

    public BaseBallGame() {
        br = new BufferedReader(new InputStreamReader(System.in));
        status = Status.PROGRESS;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    public boolean canPlay() {
        return status == Status.PROGRESS;
    }

    /**
     * 게임 시작하기 전 세팅
     *
     * @param numberSize    랜덤 숫자 길이
     */
    public void init(int numberSize) {
        computer = new Computer(numberSize);
    }

    /**
     * 답을 맞출 때까지 입력 받고 비교하기 반복
     */
    public void inputNumberAndGuess() {
        while (!computer.isCorrectAnswer()) {
            String input = inputAnswer();
            Result result = computer.compareNumberWith(input);
            printResult(result);
        }
    }

    /**
     * 플레이어의 값을 입력받고 검증
     * 올바른 값을 입력할 때까지 반복
     *
     * @return 플레이어의 입력값
     */
    private String inputAnswer() {
        String input;

        do {
            Log.REQUEST_ANSWER.print();
            input = input();
        } while (invalidAnswerSize(input));

        return input;
    }

    /**
     * 플레이어가 입력한 값이 올바른지 검증
     *
     * @param input 플레이어의 입력값
     * @return      invalid 한 값이면 true, 아니면 false
     */
    private boolean invalidAnswerSize(String input) {
        if (input.length() != computer.getNumberSize()) {
            Log.INVALID_ANSWER_SIZE.printFormat(computer.getNumberSize());
            return true;
        }

        return false;
    }

    }

    /**
     * 플레이어가 정답을 맞추고 난 후의 선택지
     * 재시작("1") | 종료("2") 중 하나를 선택할 수 있음
     * 선택하지 않으면 반복문을 벗어나지 못함
     */
    public void afterSuccess() {
        while (status == Status.SUCCESS) {
            Log.ASK_RESTART_OR_EXIT.println();
            String choice = input();
            restartOrExit(choice);
        }
    }

    private void restartOrExit(String choice) {
        if (Select.RESTART.isSelected(choice)) {
            setStatus(Status.PROGRESS);
        }

        if (Select.EXIT.isSelected(choice)) {
            setStatus(Status.EXIT);
        }
    }
    }
}
