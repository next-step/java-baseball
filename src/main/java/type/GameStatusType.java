package type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameStatusType {

	RESTART(1, "새로 시작"),
	END(2, "게임 종료"),
	;

	private final int flag;
	private final String description;

	public static final Map<Integer, GameStatusType> flagMap = new HashMap<>();
	public static final List<Integer> flagList = new ArrayList<>();

	static {
		for (GameStatusType gameStatusType : GameStatusType.values()) {
			flagMap.put(gameStatusType.getFlag(), gameStatusType);
			flagList.add(gameStatusType.getFlag());
		}
	}

	public static boolean isValidFlag(int flag) {
		return flagList.contains(flag);
	}

	public static GameStatusType findByFlag(int flag) {
		if (flagMap.containsKey(flag)) {
			return flagMap.get(flag);
		}

		throw new IllegalArgumentException();
	}
}
