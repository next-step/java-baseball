package util;

public class CustomException {

	public static class InvalidNumberFormatException extends Exception {

		public InvalidNumberFormatException(String message) {
			super(message);
		}
	}

	public static class InvalidNumberOfRangeException extends Exception {
		public InvalidNumberOfRangeException(String message) {
			super(message);
		}
	}

	public static class InvalidNumberOfSizeException extends Exception {
		public InvalidNumberOfSizeException(String message) {
			super(message);
		}
	}
}
