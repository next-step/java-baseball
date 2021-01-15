import java.util.HashMap;

public class NumberUtil {

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isSuitableNumber(String number) {
        if (number.length() != 3 || !isInteger(number)) {
            return false;
        }
        HashMap<Character, Boolean> numberHashMap = new HashMap<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0' || numberHashMap.containsKey(number.charAt(i))) {
                return false;
            }
            numberHashMap.put(number.charAt(i), true);
        }
        return true;
    }
}
