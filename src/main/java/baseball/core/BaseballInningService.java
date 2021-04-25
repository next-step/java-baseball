/**
* FileName : BaseballInningService.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball 이닝 서비스
*/
package baseball.core;

import baseball.model.InningResult;

public interface BaseballInningService {

	/**
	 * 사용자 입력 숫자를 컴퓨터 임의 생성 숫자와 비교하여 이닝 결과를 반환합니다.
	 * 
	 * @param input userInput number
	 * @return inningResult
	 */
	InningResult judgeInning(String input);

}
