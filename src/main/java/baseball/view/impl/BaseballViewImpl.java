package baseball.view.impl;

import baseball.config.BaseballConfig;
import baseball.constants.MessageKey;
import baseball.model.BaseballResult;
import baseball.view.BaseballView;

public class BaseballViewImpl extends BaseballView {
    public BaseballViewImpl(BaseballConfig config) {
        super(config);
    }

    public void printInputPrompt() {
        this.printMessage(MessageKey.inputPrompt.getKey());
    }

    public void printBaseballResult(BaseballResult baseballResult) {
        // TODO: SingleTon & Builder (BaseballConfig)
        this.print(baseballResult.toString(this.config));
    }

    public void printGameResult(BaseballResult baseballResult) {
        if (baseballResult.isComplete()) {
            this.printFormatMessage(MessageKey.successGameResultFormat.getKey(), baseballResult.getStrike());
            return;
        }

          this.printFormatMessage(MessageKey.failedGameResultFormat.getKey(), baseballResult.getStrike());
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