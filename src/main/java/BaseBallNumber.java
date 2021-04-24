import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumber {

    public static final int BASEBALL_NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    BaseBallNumber(List<Integer> list) {
        validateSize(list);
        validateDuplicate(list);
        numbers = new ArrayList<>(list);
    }

    void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException(String.format("숫자야구게임의 생성 숫자는 %d개만 가능합니다.",
                    BASEBALL_NUMBER_SIZE));
    }

    void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException("숫자야구게임의 생성 숫자는 중복될 수 없습니다.");
    }
}
