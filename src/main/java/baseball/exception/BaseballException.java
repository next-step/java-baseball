/**
* FileName : BaseballException.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : baseball game에서 발생하는 exception
*/
package baseball.exception;

public class BaseballException extends RuntimeException {

	private static final long serialVersionUID = 327120981714149286L;

	public BaseballException(String message) {
		super(message);
	}

}
