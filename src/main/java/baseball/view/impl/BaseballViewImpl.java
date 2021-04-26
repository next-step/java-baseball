package baseball.view.impl;

import baseball.config.BaseballConfig;
import baseball.constants.MessageKey;
import baseball.model.BaseballResult;
import baseball.view.BaseballView;
import baseball.view.ReaderWriter;

public class BaseballViewImpl extends BaseballView {

    public BaseballViewImpl() {
        this(new DefaultReadWriter(), BaseballConfig.getDefaultConfig());
    }

    public BaseballViewImpl(BaseballConfig config) {
        this(new DefaultReadWriter(), config);
    }

    public BaseballViewImpl(ReaderWriter io, BaseballConfig config) {
        super(io, config);
    }

    public void printInputPrompt() {
        this.printMessage(MessageKey.inputPrompt.getKey());
    }

    public void printBaseballResult(BaseballResult baseballResult) {
        // TODO: SingleTon & Builder (BaseballConfig)
        this.print(baseballResult.toString(this.config));
    }

    public void printGameResult(BaseballResult baseballResult) {
        MessageKey messageKey = baseballResult.isComplete() ? MessageKey.successGameResultFormat : MessageKey.failedGameResultFormat;

        this.printFormatMessage(messageKey.getKey(), baseballResult.getStrike());
    }

    public void printAskingReGame() {
        this.printMessage(MessageKey.askingReGamePrompt.getKey());
    }

    @Override
    public void printException(Exception e) {
        this.printFormatMessage(MessageKey.exceptionMessageFormat.getKey(), e);
    }

    public String readInputPrompt() {
        return this.read();
    }
}
