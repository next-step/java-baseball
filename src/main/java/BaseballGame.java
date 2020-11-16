import java.io.IOException;
import java.util.List;

public class BaseballGame {

    public static void main(String[] args) throws IOException {
        /**
         * 유저의 입력을 받음
         */
        List<Integer> singleDigits = KeyboardInputManager.receiveUserInput();

        /**
         * 입력받은 값 출력
         */
        for (int digit : singleDigits) {
            System.out.println(digit);
        }
    }

}
