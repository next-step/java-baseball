package baseball.view.input;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static baseball.ApplicationContext.EMPTY_DELIMITER;

public class ConsoleInput implements Input, AutoCloseable {
    private final static int RE_START_NUMBER = 1;
    private final Scanner scanner;

    public ConsoleInput(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public List<String> getNumbers() {
        final String numbers = scanner.next();
        return new ArrayList(Arrays.asList(numbers.split(EMPTY_DELIMITER)));
    }

    @Override
    public boolean wantRestart() {
        return scanner.nextInt() == RE_START_NUMBER;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
