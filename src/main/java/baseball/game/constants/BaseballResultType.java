/*
 * @(#) BaseballResultType.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.constants;

/**
 * @author 박준영
 **/
public enum BaseballResultType {
	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱");

	BaseballResultType(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}
}
