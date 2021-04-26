package kr.nais.baseball;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kr.nais.util.StringUtil;

class BaseBallServiceTest {

	@Test
	void isValidCharacterList() {
		BaseBallService baseBallService = new BaseBallService();
		Assertions.assertFalse(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("555")), "중복체크");
		Assertions.assertFalse(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("123456")), "자리수 체크");
		Assertions.assertFalse(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("asc")), "유효문자 체크");

		Assertions.assertTrue(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("123")), "정상값");
		Assertions.assertTrue(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("846")), "정상값");
		Assertions.assertTrue(baseBallService.isValidCharacterList(StringUtil.convertStringToListCharacter("483")), "정상값");
	}

	@Test
	void isValidReplayInput() {
		BaseBallService baseBallService = new BaseBallService();
		Assertions.assertFalse(baseBallService.isValidReplayInput("3"), "1, 2아닌 값 입력");

		Assertions.assertTrue(baseBallService.isValidReplayInput("1"), "1, 2 정상값 입력");
	}

	@Test
	void pitchingResult() {
		List<Character> answer = StringUtil.convertStringToListCharacter("729");
		BaseBallService baseBallService = new BaseBallService(answer);

		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("123")), "정답 아님");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("927")), "정답 아님");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("481")), "정답 아님");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("915")), "정답 아님");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("7290")), "정답 아님 - 입력값 오류");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("72")), "정답 아님 - 입력값 오류");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("")), "정답 아님 - 입력값 오류");
		Assertions.assertFalse(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter(null)), "정답 아님 - 입력값 오류");

		Assertions.assertTrue(baseBallService.pitchingResult(StringUtil.convertStringToListCharacter("729")), "정답!");
	}
}