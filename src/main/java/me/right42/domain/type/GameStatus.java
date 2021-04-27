package me.right42.domain.type;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum GameStatus {
	START("1"),
	END("2");

	private final String code;

	private static final Map<String, GameStatus> GAME_STATUS_MAP = new HashMap<>();

	static {
		for (GameStatus gameStatus : values()) {
			GAME_STATUS_MAP.put(gameStatus.getCode(), gameStatus);
		}
	}

	GameStatus(String code) {
		this.code = code;
	}

	public static GameStatus findByCode(String code) {
		return Optional.ofNullable(GAME_STATUS_MAP.get(code))
				.orElseThrow(() -> new IllegalArgumentException("해당 코드는 없습니다. [" + code + "]"));
	}

	public String getCode() {
		return code;
	}
}
