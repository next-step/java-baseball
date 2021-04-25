package exception;

public class BaseballException {

    public final static String OUT_OF_RANGE_NUMBER_ERROR = "1~9 사이 숫자로 구성 되어야 합니다.";
    public final static String DIGITS_ERROR = "세자릿수이여야 합니다.";
    public final static String DUPLICATED_ERROR = "각 자릿수의 숫자는 중복되지 않아야 합니다.";
    public final static String RESTART_ERROR = "1 또는 2만 입력 가능합니다.";
    public final static String PARSE_NUMBER_ERROR = "문자열을 숫자로 변환할 수 없습니다.";

    public static class PitcherNumberInputOutOfRangeException extends RuntimeException {
        public PitcherNumberInputOutOfRangeException() {
            super(OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    public static class DigitsException extends RuntimeException {
        public DigitsException() {
            super(DIGITS_ERROR);
        }
    }

    public static class NotBeDuplicatedException extends RuntimeException {
        public NotBeDuplicatedException() {
            super(DUPLICATED_ERROR);
        }
    }

    public static class RestartNumberInputOutOfRangeException extends RuntimeException {
        public RestartNumberInputOutOfRangeException() {
            super(RESTART_ERROR);
        }
    }

    public static class ParseNumberException extends RuntimeException {
        public ParseNumberException() {
            super(PARSE_NUMBER_ERROR);
        }
    }
}
