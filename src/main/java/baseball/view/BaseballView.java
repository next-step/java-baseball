package baseball.view;

import baseball.config.BaseballConfig;
import baseball.model.BaseballResult;
import baseball.view.impl.DefaultReadWriter;
import lombok.Setter;

public abstract class BaseballView {
    @Setter
    private ReaderWriter io;
    protected final BaseballConfig config;

    public BaseballView() {
        this(new DefaultReadWriter(), BaseballConfig.builder().build());
    }

    public BaseballView(BaseballConfig config) {
        this(new DefaultReadWriter(), config);
    }

    public BaseballView(ReaderWriter io, BaseballConfig config) {
        this.io = io;
        this.config = config;
    }

    protected void print(Object object) {
        io.print(object);
    }

    protected String read() {
        return io.read();
    }

    protected String getMessage(String key) {
        return config.getMessage(key);
    }

    protected void printMessage(String key) {
        this.print(this.getMessage(key));
    }

    protected void printFormatMessage(String key, Object ...args) {
        this.print(String.format(this.getMessage(key), args));
    }

    abstract public void printInputPrompt();

    abstract public void printBaseballResult(BaseballResult baseballResult);

    abstract public void printGameResult(BaseballResult baseballResult);

    abstract public void printAskingReGame();

    abstract public String readInputPrompt();
}
