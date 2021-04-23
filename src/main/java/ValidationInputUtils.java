public class ValidationInputUtils {
    public static boolean validInputNumber(String input) {
        boolean isNumeric = input.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isNumeric || input.length() != PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println(String.format("%d 자리의 숫자를 입력하세요.", PlayGame.RANDOM_NUMBER_LENGTH));
            return false;
        }

        return true;
    }
}
