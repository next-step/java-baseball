import java.util.Scanner;

public class BaseballGame {

    private static String answer;
    private static int restart = 1;

    static void generateRandomNumber() {
        int randomNumber = (int)(Math.random()*1000);
        String stringNumber = String.valueOf(randomNumber);
        answer = stringNumber;
    }

    static String compareNumbers(String inputNumber, String answerNumber, int inputIndex, int answerIndex) {
        String result = "";

        if ((inputIndex == answerIndex) && (inputNumber.equals(answerNumber))) {
            result = "s";
        } else if (inputNumber.equals(answerNumber)) {
            result = "b";
        }

        return result;
    }

    static boolean compare(String[] splittedAnswer, String[] splittedInput) {
        String result = "";
        int ballCount = 0;
        int strikeCount = 0;
        String[] splittedResult;

        for (int i = 0; i < splittedInput.length; i++) {
            for (int j = 0; j < splittedAnswer.length; j++) {
                result += compareNumbers(splittedInput[i], splittedAnswer[j], i, j);
            }
        }

        splittedResult = result.split("");

        for (String status:
             splittedResult) {
            if (status.equals("b")) {
                ballCount += 1;
            } else if (status.equals("s")) {
                strikeCount += 1;
            }
        }

        if (ballCount > 0 && strikeCount > 0) {
            result = ballCount+"볼 "+strikeCount+"스트라이크";
        } else if (ballCount > 0) {
            result = ballCount+"볼";
        } else if (strikeCount > 0){
            result = strikeCount+"스트라이크";
        } else {
            result = "낫싱";
        }

        System.out.println(result);

        if (strikeCount == 3) {
            return true;
        } else {
            return false;
        }
    }

    static void start() {
        Scanner scan = new Scanner(System.in);
        int input;
        String[] splittedAnswer = answer.split("");
        String[] splittedInput;
        boolean isEnd = false;
        int choice;

        while (restart == 1) {
            System.out.print("숫자를 입력해주세요 : ");

            try {
                input = scan.nextInt();
                splittedInput = String.valueOf(input).split("");

                // compare answer with input
                isEnd = compare(splittedAnswer, splittedInput);

                if (isEnd) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    choice = scan.nextInt();

                    if (choice == 2) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("예기치 않은 오류로 종료합니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        generateRandomNumber();
        start();
    }
}
