package baseball.view;

import baseball.model.BaseballResult;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class BaseballView {
    protected InputStream inputStream;
    protected OutputStream outputStream;

    public BaseballView(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    abstract public void printInputPrompt();

    abstract public void printBaseballResult(BaseballResult baseballResult);

    abstract public void printGameResult(BaseballResult baseballResult);

    abstract public void printAskingReGame();

    abstract public String readInputPrompt();

}
