package baseball.model;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

public class TestParametersProvider {
    private static final int MAX_RADIX = BaseballNumber.MAX_RADIX;

    private static List<Arguments> provideSizeAndRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = 2; radix <= MAX_RADIX; radix++) {
            for (int size = 1; size < radix; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideNonPositiveSizeOrNonPositiveSizeRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = -MAX_RADIX; radix <= 1; radix++) {
            for (int size = -MAX_RADIX; size <= 0; size++) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }

    private static List<Arguments> provideTooMuchSizeOrTooMuchRadix() {
        List<Arguments> list = new ArrayList<>();
        for (int radix = MAX_RADIX * 2; radix > MAX_RADIX; radix--) {
            for (int size = 2 * radix; size >= radix; size--) {
                list.add(Arguments.of(size, radix));
            }
        }
        return list;
    }
}
