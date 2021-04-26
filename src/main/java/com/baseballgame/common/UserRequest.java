package com.baseballgame.common;

import java.util.HashMap;
import java.util.Map;

public enum UserRequest {
	NEW_START("1"),
	END("2");

	private final String code;
	private static final Map<String, UserRequest> mappings = new HashMap<>();

	static {
		for (UserRequest userRequest : values()) {
			mappings.put(userRequest.code, userRequest);
		}
	}

	UserRequest(String code) {
		this.code = code;
	}

	public static UserRequest resolve(String code) {
		return (code != null ? mappings.get(code) : null);
	}

	public boolean matches(String code) {
		return (this == resolve(code));
	}

}
