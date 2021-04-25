package service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RuleServiceTest {
    private RuleService ruleService;

    @BeforeEach
    void setUp() {
        ruleService = new RuleService();
    }

    @DisplayName("isOverlap should return true")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    void testIsOverlapReturnTrue(int newNumber) {
        int[] arr = {1,2,5};

        assertThat(ruleService.isOverlap(arr,newNumber)).isTrue();
    }

    @DisplayName("isOverlap should return false")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void testIsOverlapReturnFalse(int newNumber) {
        int[] arr = {1,2,5};

        assertThat(ruleService.isOverlap(arr,newNumber)).isFalse();
    }
}
