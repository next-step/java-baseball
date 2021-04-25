package com.github.momentjin.service;

import com.github.momentjin.model.BaseballNumberBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberBundleFactoryTest {

    @DisplayName("입력으로 주어진 size만큼, 크키가 size인 번들이 생성되어야 한다.")
    @Test
    void inputBundleSizeTest() {
        
        // given
        BaseballNumberBundleFactory factory = new BaseballNumberBundleFactory();
        int bundleSize = 6;
        int bundleSize1 = 9;
        int bundleSize2 = 0;

        // when
        BaseballNumberBundle bundle = factory.generate(bundleSize);
        BaseballNumberBundle bundle1 = factory.generate(bundleSize1);
        BaseballNumberBundle bundle3 = factory.generate(bundleSize2);

        // then
        assertEquals(bundle.size(), bundleSize);
        assertEquals(bundle1.size(), bundleSize1);
        assertEquals(bundle3.size(), bundleSize2);
    }


    @DisplayName("bundleSize가 10보다 크면 예외가 발생한다.")
    @Test
    void inputBundleSizeTest2() {

        // given
        BaseballNumberBundleFactory factory = new BaseballNumberBundleFactory();
        int bundleSize = 11;

        // when & then
        assertThrows(RuntimeException.class, () -> {
            BaseballNumberBundle bundle = factory.generate(bundleSize);
        });
    }
}