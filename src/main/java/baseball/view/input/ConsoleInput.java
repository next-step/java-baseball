package baseball.view.input;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    @Override
    public List<String> getNumbers() {
        return null;
    }
}
