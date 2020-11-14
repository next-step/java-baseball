import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Computer {

    private final Numbers numbers;

    public Computer(Numbers numbers) {
        this.numbers = numbers;
    }

//    public

    public Numbers getNumbers() {
        return numbers;
    }

    public Result matches(Numbers userNumbers) {
        boolean isContain = numbers.isContain(userNumbers);
        if (!isContain) {
            return new Result(Arrays.asList(Score.NOTHING));
        }
        List<Score> scores = numbers.match(userNumbers);
        return new Result(new ArrayList<>(scores));
    }
}
