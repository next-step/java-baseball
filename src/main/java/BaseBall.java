import java.util.*;

public class BaseBall {

    public String unique3DigitString() {
        Integer[] arrNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> numbers = new ArrayList<>(Arrays.asList(arrNumbers));
        Collections.shuffle(numbers);

        return numbers.get(0) + "" + numbers.get(1) + "" + numbers.get(2);
    }


    public boolean checkUnique3DigitString(String input) {
        Set<String> unique = new HashSet<>(Arrays.asList(input.split("")));

        return input.matches("\\d{3}") && unique.size() == 3;
    }
}
