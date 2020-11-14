package baseball.domain;

@FunctionalInterface
public interface GameNumberGenerator {
	GameNumbers generate(int length);
}
