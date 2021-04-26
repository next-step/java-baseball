import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    }

}
