package game;

import common.ConstantUtil;

import java.util.*;

public class Hitter {

    private final List<Integer> ballList;

    public List<Integer> getBallList() {
        return ballList;
    }

    public Hitter() {
        this.ballList = createRandomBallList();
    }

    public List<Integer> createRandomBallList() {
        Set<Integer> randomNumberSet = new LinkedHashSet<>();
        Random random = new Random();

        while (randomNumberSet.size() < ConstantUtil.RANDOM_NUMBER_SIZE) {
            randomNumberSet.add(random.nextInt(ConstantUtil.RANDOM_NUMBER_MAX + ConstantUtil.RANDOM_NUMBER_MIN) + ConstantUtil.RANDOM_NUMBER_MIN);
        }

        return new ArrayList<>(randomNumberSet);
    }
}
