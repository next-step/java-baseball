package com.github.momentjin.service;

import com.github.momentjin.model.BaseballNumberBundle;
import com.github.momentjin.model.BaseballNumberBundleMatcher;
import com.github.momentjin.model.BaseballNumberDomainException;
import com.github.momentjin.model.BaseballNumberMatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseballApplicationServiceTest {

    @DisplayName("BaseballNumberDomainException 외 예외는 처리되지 않는다")
    @Test
    void checkAnswer() {

        // given
        BaseballNumberBundleMatcher matcher = new RuntimeExceptionMatcher();
        BaseballApplicationService service = new BaseballApplicationService(matcher);

        // when & then
        assertThrows(RuntimeException.class, () -> {
            service.checkAnswer(null, null);
        });
    }

    @DisplayName("BaseballNumberDomainException이 발생하면 응답 결과에 errorMessage로 포함되어 반환된다")
    @Test
    void checkAnswer2() {

        // given
        BaseballNumberBundleMatcher matcher = new BaseballNumberDomainExceptionMatcher();
        BaseballApplicationService service = new BaseballApplicationService(matcher);

        // when & then
        BaseballNumberMatchResult baseballNumberMatchResult = service.checkAnswer(null, null);

        // then
        assertTrue(baseballNumberMatchResult.isError());
    }
}

class RuntimeExceptionMatcher implements BaseballNumberBundleMatcher {

    @Override
    public BaseballNumberMatchResult match(BaseballNumberBundle origin, BaseballNumberBundle target) {
        throw new RuntimeException();
    }
}

class BaseballNumberDomainExceptionMatcher implements BaseballNumberBundleMatcher {

    @Override
    public BaseballNumberMatchResult match(BaseballNumberBundle origin, BaseballNumberBundle target) {
        throw new BaseballNumberDomainException("도메인 오류 발생!");
    }
}