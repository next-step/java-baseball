import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 문제제시
 */
public class Question {

    private List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    /**
     * 3개숫자로 이루어진 문제열 생성
     * @return
     */
    public String generate() {

        String result = "";
        int numberLength = 3;
        for (int i = 0; i < numberLength; i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(numberList.size());
            int randomElement = numberList.get(randomIndex);

            result += randomElement;

            numberList.remove(randomIndex);
        }

        return result;
    }
}
