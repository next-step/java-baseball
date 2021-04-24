import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBall {

    public String unique3DigitString() {
        Integer[] arrNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> numbers = new ArrayList<>(Arrays.asList(arrNumbers));
        Collections.shuffle(numbers);

        return numbers.get(0) + "" + numbers.get(1) + "" + numbers.get(2);
    }

}
