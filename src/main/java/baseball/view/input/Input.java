package baseball.view.input;

import java.util.List;

public interface Input {
    List<String> getNumbers();

    boolean wantRestart();
}
