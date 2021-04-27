import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private final RandomUtil randomUtil = new RandomUtil();

    public List<Integer> splitInput(int input) {
        return Arrays.asList(input / 100, input % 100 / 10, input % 10);
    }

    public boolean isValidateInputList(List<Integer> inputList) {
        //0 검사
        for (int v : inputList) {
            if (v == 0) {
                return false;
            }
        }
        //중복수 검사
        return !randomUtil.IsDuplicatedNumList(inputList);
    }

    public void isValidateInputRange(int input) {
        if (input < 100 || input >= 1000) throw new IllegalArgumentException("숫자는 3자리 수여야 합니다.");
    }

}
