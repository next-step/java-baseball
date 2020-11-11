package woo.baseball.utils;

/**
 * @author : chano
 * @Date   : 2020. 11. 11.
 * @Description : 출력에 필요한 문자열들 정의.
 */
public enum UiEnum {
	INPUTTEXT("숫자를 입력해주세요 : "),
	SUCCESSTEXT("개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	STRIKE(" 스트라이크"),
	BALL(" 볼");
	
	
	private final String text;
	
	UiEnum(String text){
		this.text=text;
	}
	public String text() {
		return this.text;
	}
	
}
