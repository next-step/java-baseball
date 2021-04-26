package baseballgame.domain;

import org.apache.commons.lang.StringUtils;

/**
 * 유저 타입
 */
public class User {

	/**
	 * 사용자 입력값 유효성 체크
	 * @param answer
	 * @return
	 */
	private boolean isValidateInput(String answer) {
		return answer.length() == 3 && StringUtils.isNumeric(answer);
	}

}
