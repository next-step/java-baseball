package game.baseball.domain;

import game.baseball.common.Action;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static game.baseball.domain.BaseBallMessage.ALREADY_OVER_GAME;

public class BaseBallGame {

    private final Consumer<String> hintConsumer;
    private final Action endAction;

    private boolean isOver;

    public BaseBallGame(Consumer<String> hintConsumer,
                        Action endAction) {
        this.hintConsumer = hintConsumer;
        this.endAction = endAction;
    }

    public void start(Supplier<String> numberSupplier) {
        start(new BaseBallNumbers(), numberSupplier);
    }

    public void start(BaseBallNumbers numbers, Supplier<String> numberSupplier) {
        if (isOver()) {
            throw new RuntimeException(ALREADY_OVER_GAME);
        }

        while (!isOver) {
            doStart(numbers, numberSupplier);
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public void undoOver() {
        isOver = false;
    }

    public void doStart(BaseBallNumbers numbers, Supplier<String> numberSupplier) {
        BaseBallNumbers userNumbers = new BaseBallNumbers(numberSupplier.get());
        NumberHint hint = numbers.getHint(userNumbers);
        hintConsumer.accept(hint.getMarking());

        if (hint.isThreeStrike()) {
            endAction.action();
            isOver = true;
        }
    }

    public static class Builder {
        private Consumer<String> hintConsumer = hint -> {};
        private Action endAction = () -> {};

        public Builder peekHint(Consumer<String> hintConsumer) {
            this.hintConsumer = hintConsumer;
            return this;
        }

        public Builder gameEnded(Action endAction) {
            this.endAction = endAction;
            return this;
        }

        public BaseBallGame build() {
            return new BaseBallGame(hintConsumer, endAction);
        }
    }
}
