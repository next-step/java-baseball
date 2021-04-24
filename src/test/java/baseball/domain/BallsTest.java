package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    @DisplayName("공들을 생성할 때 공을 여러개 받을 수 있다")
    public void 공들을_생성할_때_공을_여러개_받을_수_있다() {
        assertThatNoException().isThrownBy(() -> new Balls(Ball.of(1), Ball.of(2), Ball.of(3)));
    }

    @Test
    @DisplayName("공들안에는 같은 숫자가 존재해서는 안된다")
    public void 공들안에는_같은_숫자가_존재해서는_안된다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Balls(Ball.of(1), Ball.of(1)));
    }

    @Test
    @DisplayName("공들 안에 공의 위치를 알아 낼 수 있다.")
    public void 공들_안에_공의_위치를_알아_낼_수_있다() {
        Balls balls = new Balls(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(balls.findPositionByBall(Ball.of(1)))
                .isEqualTo(new Position(0));
        assertThat(balls.findPositionByBall(Ball.of(2)))
                .isEqualTo(new Position(1));
        assertThat(balls.findPositionByBall(Ball.of(3)))
                .isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("공들 안에 찾고자 하는 공이 없으면, NOT_FOUND을 반환한다")
    public void 공들_안에_찾고자_하는_공이_없으면_NOT_FOUND을_반환한다() {
        Balls balls = new Balls(Ball.of(1), Ball.of(2), Ball.of(3));

        assertThat(balls.findPositionByBall(Ball.of(4)))
                .isEqualTo(Position.NOT_FOUND);
    }

    @ParameterizedTest
    @MethodSource("createMatchingPackageSource")
    @DisplayName("공들과 공들은 매칭하여, 결과를 도출 할 수 있다.")
    public void 공들과_공들은_매칭하여_결과를_도출_할_수_있다(MatchingPackage matchingPackage) {
        GameRules match = matchingPackage.getSource().match(matchingPackage.getDest());

        assertThat(match.countOfStrike()).isEqualTo(matchingPackage.getCountOfStrike());
        assertThat(match.countOfBall()).isEqualTo(matchingPackage.getCountOfBall());
        assertThat(match.countOfMissing()).isEqualTo(matchingPackage.getCountOfMissing());
    }

    private static List<MatchingPackage> createMatchingPackageSource() {
        List<MatchingPackage> matchingPackages = new ArrayList<>();

        matchingPackages.add(new MatchingPackage(
                Arrays.asList(7, 1, 3),
                Arrays.asList(1, 2, 3),
                1,
                1,
                1
        ));

        matchingPackages.add(new MatchingPackage(
                Arrays.asList(7, 1, 3),
                Arrays.asList(1, 4, 5),
                0,
                1,
                2
        ));

        matchingPackages.add(new MatchingPackage(
                Arrays.asList(7, 1, 3),
                Arrays.asList(6, 7, 1),
                0,
                2,
                1
        ));

        matchingPackages.add(new MatchingPackage(
                Arrays.asList(7, 1, 3),
                Arrays.asList(2, 1, 6),
                1,
                0,
                2
        ));

        matchingPackages.add(new MatchingPackage(
                Arrays.asList(7, 1, 3),
                Arrays.asList(7, 1, 3),
                3,
                0,
                0
        ));

        return matchingPackages;
    }

    private static class MatchingPackage {
        private Balls source;
        private Balls dest;
        private int countOfStrike;
        private int countOfBall;
        private int countOfMissing;

        public MatchingPackage(List<Integer> source, List<Integer> dest, int countOfStrike, int countOfBall, int countOfMissing) {
            this.source = new Balls(source.stream().map(Ball::of).collect(Collectors.toList()));
            this.dest = new Balls(dest.stream().map(Ball::of).collect(Collectors.toList()));
            this.countOfStrike = countOfStrike;
            this.countOfBall = countOfBall;
            this.countOfMissing = countOfMissing;
        }

        public Balls getSource() {
            return source;
        }

        public Balls getDest() {
            return dest;
        }

        public int getCountOfStrike() {
            return countOfStrike;
        }

        public int getCountOfBall() {
            return countOfBall;
        }

        public int getCountOfMissing() {
            return countOfMissing;
        }
    }
}
