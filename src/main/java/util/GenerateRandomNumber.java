package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class GenerateRandomNumber {

	private static final Random RANDOM_INSTANCE = new Random();


	/**
	 * 서로 다른 숫자 리스트 생성
	 * @param range: 랜덤 숫자 범위, 1 이상
	 * @param pickSize: 뽑을 숫자 갯수
	 * @return
	 */
	public static List<Integer> generate(int range, int pickSize) {
		if(range < 1) return Collections.emptyList(); // 기저사례1, range가 1보다 작으면 빈 결과 리턴
		if(pickSize > range-1) return Collections.emptyList(); // 기저사례2, range보다 뽑는 수가 크면 빈 결과 리턴

		int index = 0;
		List<Integer> result = new ArrayList<>();
		while(index < pickSize){ // pickSize만큼 뽑힐때까지 반복
			int pickedNum = RANDOM_INSTANCE.nextInt(range-1)+1; // 랜덤숫자 뽑기
			index = addResultDoesNotDuplication(result, pickedNum, index);
		}

		return result;
	}

	private static int addResultDoesNotDuplication(List<Integer> result, int pickedNum, int index){
		// 이미 뽑힌 숫자면 index를 증가시키지않고 return
		if(result.contains(pickedNum)){
			return index;
		}

		result.add(pickedNum);
		return index + 1;
	}

}
