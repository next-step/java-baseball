package domain;

@FunctionalInterface
public interface ChoiceStrategy {
    Numbers generate();
}
