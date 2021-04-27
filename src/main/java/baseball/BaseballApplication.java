/**
* FileName : BaseballApplication.java
* Created  : 2021. 4. 24.
* Author   : youngjun.jin
* Summary  : Baseball game main class
*/
package baseball;

import baseball.core.BaseballGameExecutor;

public class BaseballApplication {

	public static void main(String[] args) {
		BaseballGameExecutor baseballGameExecutor = new BaseballGameExecutor();
		baseballGameExecutor.execute();
	}
}
