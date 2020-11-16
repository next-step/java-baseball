package com.nextstep.example.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class HitterTest {

	private Hitter hitter;

	@BeforeEach
	protected void setUp() throws Exception {
		hitter = new Hitter();
	}

	@DisplayName("서로 다른 수로 이루어진 3자리 수 확인")
	@Test
	void testPredictPitching() {
		hitter.predictPitching();
		String prediction = hitter.getPitchPrediction();
		List<String> list = Arrays.asList(prediction.split(""));
		Set<String> set = new HashSet<>(list);
		assertThat(prediction.length()).isEqualTo(set.size());
	}

}
