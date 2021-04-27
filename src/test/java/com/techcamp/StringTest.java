package com.techcamp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class StringTest {
    private static final Logger logger = LoggerFactory.getLogger(StringTest.class);

    @Test
    void 요구사항1_테스트() {
        assertThat("1,2".split(","))
                .contains("1").contains("2");
        assertThat("1".split(","))
                .containsExactly("1");
    }

    @Test
    void 요구사항2_테스트() {
        String text = "(1,2)";
        logger.info("result : {}", text.substring(1, text.length()-1));
    }

    @DisplayName("특정문자의 위치를 가져오는 기능 테스트")
    @Test
    void 요구사항3_테스트() {
        String text = "abc";
        assertThatThrownBy(()->{
            logger.info("result: {}", String.valueOf(text.charAt(3)));
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("index out of range", text);
    }
}
