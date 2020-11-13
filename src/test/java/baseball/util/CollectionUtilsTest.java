package baseball.util;

import baseball.domain.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionUtilsTest {
    static Stream<Arguments> generateEmptyCollectionData() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(new HashSet())
        );
    }

    static Stream<Arguments> generateValidCollectionData() {
        return Stream.of(
            Arguments.of(Arrays.asList(GameNumber.getInstance(1))),
            Arguments.of(new HashSet(Arrays.asList(GameNumber.getInstance(1))))
        );
    }

    @DisplayName("isEmpty() - null 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - collection={0}")
    @MethodSource("generateEmptyCollectionData")
    @NullSource
    void isEmptyForNullAndEmpty(Collection<GameNumber> collection) {
        assertThat(CollectionUtils.isEmpty(collection)).isTrue();
    }

    @DisplayName("isEmpty() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - collection={0}")
    @MethodSource("generateValidCollectionData")
    void isEmpty(Collection<GameNumber> collection) {
        assertThat(CollectionUtils.isEmpty(collection)).isFalse();
    }
}