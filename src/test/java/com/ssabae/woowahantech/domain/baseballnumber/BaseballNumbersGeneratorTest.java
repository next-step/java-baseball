package com.ssabae.woowahantech.domain.baseballnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-15
 */
@DisplayName("야구 게임 번호 생성 테스트")
class BaseballNumbersGeneratorTest {

    BaseballNumbersGenerator generator = new BaseballNumbersGenerator();

    @Test
    @DisplayName("게임 번호 생성 테스트")
    void generateTest() {
        BaseballNumbers generate = generator.generate();
        assertThat(generate).isNotNull();
    }


    @Test
    @DisplayName("중복 번호 없는 Set 생성 테스트")
    void generateNotDuplicatedNumberSetTest() {
        Set<Integer> generatedSet = generator.generateNotDuplicatedNumberSet();
        assertThat(generatedSet).hasSize(3);
        generatedSet.forEach(number -> assertThat(generatedSet).containsOnlyOnce(number));

    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    @DisplayName("1~9까지의 랜덤 번호 생성 테스트")
    void generateBoundedRandomNumberTest() {
        Integer randomNumber = generator.generateBoundedRandomNumber();
        assertThat(randomNumber).isGreaterThan(0);
        assertThat(randomNumber).isLessThan(10);
    }
}