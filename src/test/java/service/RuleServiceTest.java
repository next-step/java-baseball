package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RuleServiceTest {
    private RuleService ruleService;
    private static final int[] BOT_NUMBER = {1,2,5};

    @BeforeEach
    void setUp() {
        ruleService = new RuleService();
    }

    @DisplayName("isOverlap should return true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    void testIsOverlapReturnTrue(int newNumber) {
        assertThat(ruleService.isOverlap(BOT_NUMBER,newNumber)).isTrue();
    }

    @DisplayName("isOverlap should return false")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void testIsOverlapReturnFalse(int newNumber) {
        assertThat(ruleService.isOverlap(BOT_NUMBER,newNumber)).isFalse();
    }

    @DisplayName("The number of strikes should be correct")
    @Test
    void testCountStrike() {
        assertThat(ruleService.countStrike(BOT_NUMBER, new int[]{6, 7, 8})).isEqualTo(0);
        assertThat(ruleService.countStrike(BOT_NUMBER, new int[]{1, 3, 4})).isEqualTo(1);
        assertThat(ruleService.countStrike(BOT_NUMBER, new int[]{1, 2, 3})).isEqualTo(2);
        assertThat(ruleService.countStrike(BOT_NUMBER, new int[]{1, 2, 5})).isEqualTo(3);
    }
}
