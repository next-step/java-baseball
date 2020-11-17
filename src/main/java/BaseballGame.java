import java.io.IOException;

public class BaseballGame {

    static int answer;

    public static void main(String[] args) throws IOException {
        /**
         * 컴퓨터의 정답을 생성
         */
        answer = NumberGenerator.makeRandomThreeDigit();

        while (true) {
            // 유저의 입력을 받음
            int userInput = KeyboardInputManager.receiveUserInput();
            // 컴퓨터의 정답과 비교하여 결과를 도출
            BaseballCompareResult result = NumberComparator.compare(answer, userInput);

            switch (result.getStatus()) {
                case NOTHING:   // 맞는게 하나도 없는 경우
                    System.out.println("낫싱");
                    break;
                case EXIST:     // 볼 또는 스트라이크가 존재하는 경우
                    System.out.println(result.getStrikeCount() + "스트라이크, " + result.getBallCount() + "볼");
                    break;
                case MATCHED:   // 정답을 맞춘 경우
                    System.out.println("정답입니다! 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    if(doAgainOrNot() == false) return;
            }
        }

    }

    private static boolean doAgainOrNot() throws IOException {
        String userAction = KeyboardInputManager.receiveKeyboardInput();
        if (userAction.equals("1")) {
            System.out.println("게임을 새로 시작합니다.");
            // 정답 초기화
            answer = NumberGenerator.makeRandomThreeDigit();
            return true;
        } else {
            System.out.println("종료되었습니다.");
            return false;
        }
    }

}
