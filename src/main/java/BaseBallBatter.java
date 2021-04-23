import javax.sound.midi.Soundbank;

/**
 * User
 * <p>
 * receive command line input, valid number input only
 */
public class BaseBallBatter {
    public String getUserInput() {
        boolean pass;
        String input;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = PlayGame.scanner.nextLine();
            pass = validation(input);
        } while (!pass);

        return input;
    }

    private boolean validation(String input) {
        if (input.length() != PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println(String.format("%d 자리의 숫자를 입력하세요.", PlayGame.RANDOM_NUMBER_LENGTH));
            return false;
        }

        if (!ValidationInputUtils.validInputNumber(input)) {
            System.out.println("숫자만 입력하세요.");
            return false;
        }

        if (!ValidationInputUtils.validInputDuplication(input)) {
            System.out.println("중복되지 않은 숫자만 입력하세요.");
            return false;
        }

        return true;
    }

}
