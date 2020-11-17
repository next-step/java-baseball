package baseball.players.opponent;

import java.util.List;
import java.util.Scanner;

import baseball.utils.DataConvertUtils;

public class Person implements Opponent {
	private List<Integer> hiddenNumber;

	public Person() {
		this.hiddenNumber = initHiddenNumber();
	}

	@Override
	public List<Integer> getHiddenNumbers() {
		return this.hiddenNumber;
	}

	@Override
	public void reset() {
		this.hiddenNumber = initHiddenNumber();
	}

	private List<Integer> initHiddenNumber() {
		System.out.print("비밀 번호를 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String hiddenNumbers = scanner.nextLine();

		//todo 입력값 벨리데이션 추가
		//todo 입력한 비밀번호 감추는 로직 추가
		//todo 입력 문구 Display로 빼기
		return DataConvertUtils.convertToIntegerArrays(hiddenNumbers);
	}
}
