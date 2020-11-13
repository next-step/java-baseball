package baseball;

@FunctionalInterface
public interface GameNumberGenerator {
	GameNumbers generate(int length);
}
