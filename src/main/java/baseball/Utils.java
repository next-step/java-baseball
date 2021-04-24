package baseball;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<Integer> stringToIntegerList(String answer) {
		String[] answerNumberStrings = answer.split(",");
		List<Integer> answerNumberList = new ArrayList<>();
		for (String numberString : answerNumberStrings) {
			answerNumberList.add(Integer.parseInt(numberString));
		}
		return answerNumberList;
	}
}
