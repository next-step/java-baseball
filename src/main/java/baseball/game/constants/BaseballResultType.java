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

	BaseballResultType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}
}
