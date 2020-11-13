package utils;

import static domain.enums.ErrorType.*;

/**
 * @author : byungkyu
 * @date : 2020/11/13
 * @description : BusinessException
 **/
public class BusinessException extends RuntimeException {
	public static class BaseballNumberOutOfInvalidArrangeException extends RuntimeException {

		public BaseballNumberOutOfInvalidArrangeException() {
			super(BASEBALL_NUMBER_OF_INVALID_ARRANGE_EXCEPTION.getMessage());
		}
	}

	public static class BaseballNumberOnlyNumberException extends RuntimeException {
		public BaseballNumberOnlyNumberException() {
			super(BASEBALL_NUMBER_ONLY_NUMBER_EXCEPTION.getMessage());
		}
	}

	public static class BaseballNumberMustThreeNumberException extends RuntimeException {
		public BaseballNumberMustThreeNumberException() {
			super(BASEBALL_NUMBER_MUST_THREE_EXCEPTION.getMessage());
		}
	}

	public static class BaseballNumberDuplicatedException extends RuntimeException {
		public BaseballNumberDuplicatedException() {
			super(BASEBALL_NUMBER_DUPLICATE_EXCEPTION.getMessage());
		}
	}

	public static class ChooseRetryNumberException extends RuntimeException {
		public ChooseRetryNumberException() {
			super(CHOOSE_RETRY_NUMBER_EXCEPTION.getMessage());
		}
	}
}
