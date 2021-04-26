package baseballgame.number;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class AnswerNumber implements BaseballNumber {

    private final List<String> number;

    public AnswerNumber() {
        this.number = generateAnswer();
    }

    private List<String> generateAnswer(){
        List<String> numberPool = Arrays.asList("1","2","3","4","5","6","7","8","9");
        Collections.shuffle(numberPool);
        return numberPool.subList(0, 3);
    }

    @Override
    public List<String> getNumber() {
        return number;
    }
}
