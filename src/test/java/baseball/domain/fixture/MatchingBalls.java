package baseball.domain.fixture;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingBalls {
    public static List<MatchingPackage> createMatchingPackageSource() {
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

    public static class MatchingPackage {
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
