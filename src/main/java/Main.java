import java.util.Scanner;

public class Main {

    private final static int BASEBALL_DIGIT = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Validation validation = new Validation();

        MakeNumber makeNumber = new MakeNumber();
        String targetNumber = makeNumber.makeRandomNumber(BASEBALL_DIGIT);

        while (true) {
            int ballCnt = 0;
            int strikeCnt = 0;

            System.out.println("숫자를 입력하세요.");
            String inputValue = sc.nextLine();

            //숫자만 추출
            String extractValue = makeNumber.extractNumber(inputValue);

            String message = validation.validateInputValue(extractValue, BASEBALL_DIGIT);

            if(message != null) {
                System.out.println(message);
                continue;
            }

            Result result = new Result();

            int i = 0;
            boolean isContinued = true;
            while (isContinued) {
                ballCnt += result.isBall(extractValue, targetNumber, i) ? 1 : 0;
                strikeCnt += result.isStrike(extractValue, targetNumber, i) ? 1 : 0;

                if ((i + 1) == BASEBALL_DIGIT) {
                    isContinued = false;
                }
                i++;
            }

            System.out.println("Ball Count : " + ballCnt);
            System.out.println("Strike Count : " + strikeCnt);

            if (strikeCnt != BASEBALL_DIGIT) {
                continue;
            }

            if (strikeCnt == BASEBALL_DIGIT) {
                break;
            }
        }

    }

}