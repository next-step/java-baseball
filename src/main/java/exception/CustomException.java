package exception;

public class CustomException extends RuntimeException {
	public static class BaseballNumberNotAvailableException extends RuntimeException {
		public BaseballNumberNotAvailableException() {
			super("허용되지 않는 값이 입력됐습니다 확인해주세요");
		}
	}

	public static class BaseballNumberExceedSizeException extends RuntimeException {
		public BaseballNumberExceedSizeException() {
			super("허용된 길이를 초과했습니다. 확인해주세요");
		}
	}

	public static class BaseballNumberDuplicatedException extends RuntimeException {
		public BaseballNumberDuplicatedException() {
			super("중복된 숫자가 있습니다 확인해주세요");
		}
	}
}
