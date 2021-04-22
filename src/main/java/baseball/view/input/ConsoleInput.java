package baseball.view.input;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public List<String> getNumbers() {
        final String numbers = scanner.next();
        final String DELIMITER = "";
        return new ArrayList(Arrays.asList(numbers.split(DELIMITER)));
    }

}
