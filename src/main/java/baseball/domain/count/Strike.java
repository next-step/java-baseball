package baseball.domain.count;

import baseball.domain.Numbers;

public class Strike implements Count {
    private int count = 0;

    @Override
    public int count(final Numbers randomNumbers, final Numbers userNumbers) {
        count = 0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            check(randomNumbers, userNumbers, i);
        }
        return count;
    }

    private void check(final Numbers randomNumbers, final Numbers userNumbers, final int i) {
        if (randomNumbers.get(i).equals(userNumbers.get(i))) {
            count++;
        }
    }
}
