package domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class Computer {
	// 세 자리 난수를 생성한다
	public static String generateNumber() {

		// 변수 선언
		Random random = new Random();
		HashSet<String> numberSet = new LinkedHashSet<>(3);
		StringBuilder returnStr = new StringBuilder();

		while (numberSet.size() < 3) {
			// 1~9 사이의 난수를 생성한다.
			String randomNumber = Integer.toString(random.nextInt(9) + 1);

			// 중복제거를 위해 HashSet에 추가해준다.
			numberSet.add(randomNumber);
		}

		for (String randomNumber : numberSet) {
			returnStr.append(randomNumber);
		}

		return returnStr.toString();
	}
}
