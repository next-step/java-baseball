package features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberUtil {
    /**
     * Return three unique random numbers.
     * @return list {list of integers} with length of 3.
     */
    public static List<Integer> generateAnswer() {
        // Create list of integers that contains 1-9.
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Shuffle the list
        Collections.shuffle(answer);
        return answer.subList(0, 3);
    }

  /**
   * Convert given string to list and returns it.
   * @param string {contains only integers} Cannot be null.
   * @return list {list of integers} with same order as param.
   */
  public static List<Integer> convertString(String userInput) {
        // Create Empty list.
        List<Integer> converted = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            // Convert each string of numbers to integer.
            converted.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return converted;
    }
}
