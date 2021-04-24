package type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PitchingResultType {

	STRIKE("스트라이크"),
	BALL("볼"),
	OUT("아웃"),
	;

	private final String description;

	public String generateMessage(int count) {
		return (count == 0)
			? ""
			: count + " " + this.getDescription() + " ";
	}
}
