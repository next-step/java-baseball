package baseball.domain.count;

import baseball.domain.Numbers;

public class Ball implements Count {
    private int count = 0;

    @Override
    public int count(Numbers randomNumbers, Numbers userNumbers) {
        count = 0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            check(randomNumbers, userNumbers, i);
        }
        return count;
    }

    private void check(Numbers randomNumbers, Numbers userNumbers, int i) {
        if (!(randomNumbers.get(i).equals(userNumbers.get(i))) && randomNumbers.contains(userNumbers.get(i))) {
            count++;
        }
    }
}
