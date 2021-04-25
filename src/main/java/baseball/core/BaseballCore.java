package baseball.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballCore {

	private boolean isEndGame = true;
	private Set<Character> numbersForReset = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
	private List<Character> numbersForGame = new ArrayList<>();

	/**
	 * 컴퓨터가 게임을 생성한다.
	 */
	private void makeGame() {
		this.isEndGame = false; //게임 진행 상태로 변경

		// 임의의 값 생성
		List<Character> tempNumberList = new ArrayList<>();
		tempNumberList.addAll(this.numbersForReset);
		Collections.shuffle(tempNumberList);

		// 게임 초기화
		this.numbersForGame.clear();
		this.numbersForGame.addAll(tempNumberList.subList(0, 3));
	}

}
