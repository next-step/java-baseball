import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final String BLANK = "";

    public List<Integer> getUserRequest() throws IllegalArgumentException {
        List<String> rawInput = Arrays.asList(scanner.nextLine().split(BLANK));
        List<Integer> userInput = inputTypeConverter(rawInput);
        if (!isValid(userInput)) throw new IllegalArgumentException();
        return userInput;
    }

    private List<Integer> inputTypeConverter(List<String> list) throws NumberFormatException {
        List<Integer> ret = new ArrayList<>();
        for (String s : list) {
            ret.add(Integer.parseInt(s));
        }
        return ret;
    }

    private boolean isValid(List<Integer> userInput) {
        if (!isThreeNumber(userInput)) return false;
        if (!isNotZeroInput(userInput)) return false;
        return true;
    }

    private boolean isThreeNumber(List<Integer> userInput) {
        return (userInput.size() == 3);
    }

    private boolean isNotZeroInput(List<Integer> userInput) {
        boolean ret = true;
        for (Integer number : userInput) {
            ret &= (number != 0);
        }
        return ret;
    }

    public Command getUserCommand() throws IllegalArgumentException {
        int userCmd = Integer.parseInt(scanner.nextLine());
        Command ret =  Command.getCommand(userCmd);
        if (ret == Command.UNDEFINED) throw new IllegalArgumentException();
        return ret;
    }

}
