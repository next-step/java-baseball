package com.baseball.precourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 김윤제
 *
 */
public class Computer {
	private static final int MAX_SIZE = 3;
	private static final int MAX_NUM = 9;
    private static final int ONE = 1;
	
	/**
	 *  랜덤번호 3자리 반환
	 * @return List<Integer> 서로 다른 임의의 랜덤번호 3자리
	 */
	public List<Integer> getRandomNums() {
	
		List<Integer> selectedNumList = new ArrayList<>(MAX_NUM);
		while ( selectedNumList.size() < MAX_SIZE ) {
			selectedNumList = processDuplicateNum(selectedNumList, generateRandomNum());
		}
		return selectedNumList;
	}
	/**
	 * 컴퓨터가 랜덤 번호 생성
	 * @return int 랜덤번호 1자리
	 */
	public int  generateRandomNum() {
		Random random = new Random();
		int num = random.nextInt(MAX_NUM)+ONE;
		return num;
	}
	
	/**
	 * 각 자리마다 서로 다른 수를 가진 리스트를 반환
	 * @return List<Integer> 중복 처리
	 */
	public List<Integer> processDuplicateNum(List<Integer> selectedNumList, int generatedNum) {
		if ( !selectedNumList.contains(generatedNum) ) {
			selectedNumList.add(generatedNum);
		}
		return selectedNumList;
	}
}
