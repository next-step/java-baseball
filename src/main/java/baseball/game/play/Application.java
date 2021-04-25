/*
 * @(#) Application.java 2021. 04. 25.
 *
 * Created by cooingpop
 */

package baseball.game.play;

import baseball.game.constants.GameStatusType;

/**
 * @author 박준영
 **/
public class Application {
	public static void main(String[] args) {
		System.out.println("야구 게임시작");
		Baseball baseball = new Baseball();
		baseball.initialize();

		while (GameStatusType.START.equals(baseball.type)) {
			baseball.inputNumbers();
			System.out.println(baseball.getResultMessage());
		}

	}
}
