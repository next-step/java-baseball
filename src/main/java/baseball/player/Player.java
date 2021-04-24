package baseball.player;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@EqualsAndHashCode
public abstract class Player {

	private List<Integer> numberList;

	public void updateNumberList(List<Integer> newNumberList) {
		this.numberList = Collections.unmodifiableList(newNumberList);
	}
}
