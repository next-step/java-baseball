package kr.nais.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import kr.nais.util.StringUtil;

public class BaseBallService {

	private final Scanner scanner;
	private List<Character> answer;

	public BaseBallService() {
		scanner = new Scanner(System.in);
	}

	public BaseBallService(List<Character> answer) {
		scanner = new Scanner(System.in);
		this.answer = answer;
	}

	/**
	 * 게임 정답 생성
	 */
	public void createAnswer() {
		List<Character> numbers = new ArrayList<>(
			Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
		Collections.shuffle(numbers);

		this.answer = numbers.subList(0, 3);
	}

	/**
	 * 게임 시작
	 */
	public void play() {
		boolean isOut;
		do {
			List<Character> pitching = this.inputText();
			isOut = this.pitchingResult(pitching);
		} while (!isOut);

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public List<Character> inputText() {
		List<Character> pitching;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			String input = scanner.nextLine();
			pitching = StringUtil.convertStringToListCharacter(input);

			if (!isValidCharacterList(pitching)) {
				pitching = null;
				System.out.println("입력값이 유효하지 않습니다. 다시 입력해 주세요!(유효 숫자 범위: 1 ~ 9, 3자리, 중복 허용안함)");
			}
		} while (pitching == null);

		return pitching;
	}

	/**
	 *  입력값 유효성 검사 - 입력값 3자리, 유효 문자
	 * @param characterList 입력값
	 * @return 유효성 결과 판단
	 */
	public boolean isValidCharacterList(List<Character> characterList) {
		if(characterList == null)
			return false;

		List<Character> characters = new ArrayList<>(
			Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
		
		//중복 제거
		Set<Character> set = new HashSet<>(characterList);

		return set.size() == 3 && characters.containsAll(set);
	}


	/**
	 * 타자 상대 결과
	 *
	 * @param pitching 입려한 값
	 * @return 삼진 여부
	 */
	public boolean pitchingResult(List<Character> pitching) {
		if(!isValidCharacterList(pitching)) {
			return false;
		}

		int[] ballCount = new int[2]; //스트라이크, 볼 숫자

		for (Character ball : pitching) {
			this.judgment(ball, pitching.indexOf(ball), ballCount);
		}

		System.out.println(this.printBallCount(ballCount));

		return ballCount[0] == 3;
	}

	/**
	 * 볼 결과값 출력
	 *
	 * @param ballCount 볼카운트
	 */
	private String printBallCount(int[] ballCount) {
		List<String> printBoard = new ArrayList<>();
		if (ballCount[0] > 0) {
			printBoard.add(ballCount[0] + " 스트라이크");
		}
		if (ballCount[1] > 0) {
			printBoard.add(ballCount[1] + " 볼");
		}
		if (printBoard.isEmpty()) {
			printBoard.add("낫씽");
		}

		return String.join(" ", printBoard);
	}

	/**
	 * 스트라이크/볼 판정
	 *
	 * @param ball      - 공
	 * @param index     - 던진 횟 수
	 * @param ballCount - 볼카운트
	 */
	public void judgment(Character ball, int index, int[] ballCount) {
		//스트라이크
		if (this.answer.get(index).equals(ball)) {
			ballCount[0] = ballCount[0] + 1;
			//볼
		} else if (this.answer.contains(ball)) {
			ballCount[1] = ballCount[1] + 1;
		}
	}

	/**
	 * 재시작 여부
	 *
	 * @return 재시작 여부
	 */
	public boolean isReplay() {
		String replayValue;
		do {
			System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
			replayValue = scanner.nextLine();

			if(!isValidReplayInput(replayValue)) {
				System.out.println("입력값이 잘못 되었습니다. 1 또는 2만 입력하세요!");
				replayValue = null;
			}
		} while (replayValue == null);

		return "1".equals(replayValue);
	}

	/**
	 *
	 * @param replayValue 리플레이 입력값
	 * @return 유효성 검사
	 */
	public boolean isValidReplayInput(String replayValue) {
		return Arrays.asList("1", "2").contains(replayValue);
	}
}