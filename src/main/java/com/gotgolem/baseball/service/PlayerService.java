package com.gotgolem.baseball.service;

import java.util.HashSet;
import java.util.Set;

import com.gotgolem.baseball.asset.pitch.ThreePitches;
import com.gotgolem.baseball.exception.PlayerInputException;

public class PlayerService {

	private final BaseballService baseballService;

	public PlayerService(BaseballService baseballService) {
		this.baseballService = baseballService;
	}

	public ThreePitches parsePitchesString(String pitchesString) {
		pitchesString = removeWhitespaces(pitchesString);
		validatePitchesString(pitchesString);
		return baseballService.createThreePitches(toIntArray(pitchesString));
	}

	private void validatePitchesString(String pitchesString) {
		if (isBlank(pitchesString)
				|| containsNonDigit(pitchesString)
				|| hasDuplicateCharacters(pitchesString)
				|| pitchesString.contains("0")
				|| pitchesString.length() != 3) {
			throw new PlayerInputException("1-9까지의 중복되지 않는 3자리의 숫자여야 합니다.");
		}
	}

	private String removeWhitespaces(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("\\s", "");
	}

	private boolean isBlank(String str) {
		return str == null || str.trim().isEmpty();
	}

	private boolean containsNonDigit(String str) {
		return str.matches("^\\D*$");
	}

	private boolean hasDuplicateCharacters(String str) {
		final Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		return set.size() < str.length();
	}

	private int[] toIntArray(String str) {
		final int[] array = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			array[i] = Integer.parseInt(str.charAt(i) + "");
		}
		return array;
	}

}
