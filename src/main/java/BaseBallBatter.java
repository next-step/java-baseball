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
            pass = ValidationInputUtils.validInputNumber(input);
        } while (!pass);

        return input;
    }
}
