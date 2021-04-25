/**
* FileName : RandomNumberGenerator.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : random number generator service interface
*/
package baseball.core;

import baseball.model.BaseballNumber;

public interface BaseballNumberService {

	/**
	 * random으로 생성된 서로다른 세 수를 반환합니다.
	 * @author youngjun.jin
	 * @return BaseballNumber
	 */
	BaseballNumber getRandomBaseballNumber();
}
