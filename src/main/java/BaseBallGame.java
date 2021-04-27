import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    char[] answer = new char[3];

    /**
     * 컴퓨터 답안 생성
     * (중복되지 않는 1~9 사이의 숫자 3자리)
     */
    protected void generateAnswer() {
        List<Character> numbers = Arrays.asList('1','2','3','4','5','6','7','8','9');
        Collections.shuffle(numbers);
        answer[0] = numbers.get(0);
        answer[1] = numbers.get(1);
        answer[2] = numbers.get(2);
    }

    /**
     * 게임 스타트
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            round(scanner);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String input = scanner.next();
            if(input.equals("2")) {
                break;
            }
        }

        scanner.close();
    }

    /**
     * 사용자 입력 validate
     * @param input
     */
    protected boolean validateUserInput(String input) {
        return input.length() != 3;
    }

    /**
     * 한 라운드
     */
    private void round(Scanner scanner) {
        generateAnswer();
        System.out.print("숫자를 입력해주세요 : ");
        while(true) {
            String input = scanner.next();
            // 3자리인지 체크
            if (validateUserInput(input)) {
                System.out.println("3자리의 숫자를 입력해주세요");
                continue;
            }

            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                for(int ii = 0; ii < 3; ii++) {
                    // 문자도 일치하고, 인덱스도 같으면 스트라이크
                    if(input.charAt(i) == answer[ii] && i == ii) {
                        strikeCount++;
                        break;
                    }
                    // 다른자리라도 있으면 볼
                    if(input.charAt(i) == answer[ii]) {
                        ballCount++;
                        break;
                    }
                }
            }

            if(strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if(strikeCount == 0 && ballCount == 0) {
                System.out.println("포볼");
                continue;
            }

            ArrayList<String> messages = new ArrayList<>();
            if(strikeCount > 0) {
                messages.add(strikeCount + " 스트라이크");
            }
            if(ballCount > 0) {
                messages.add(ballCount + " 볼");
            }
            System.out.println(String.join(" ", messages));
        }
    }



}
