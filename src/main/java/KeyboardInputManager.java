import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class KeyboardInputManager {

    /**
     * 1~9 사이의 서로 다른 수로 이루어진 세자리 수를 입력받아서,
     * 각 자리수를 배열에 담아 리턴하는 메소드
     */
    public static int receiveUserInput() {
        try {
            System.out.println("서로 다른 수로 이루어진 세자리 숫자를 입력해주세요. (1~9 사이의 수)");
            int input = Integer.parseInt(receiveKeyboardInput());

            if (NumberGenerator.checkRightData(input)) return input;
            else return receiveUserInput();
        } catch (Exception e) {
            return receiveUserInput();
        }
    }

    /**
     * 키보드로부터 한줄 입력받는 메소드
     */
    public static String receiveKeyboardInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }

}
