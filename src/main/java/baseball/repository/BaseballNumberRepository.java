package baseball.repository;

import baseball.domain.BaseballNumbers;
import baseball.infra.BaseballDatabase;

public class BaseballNumberRepository {

    public void save(BaseballNumbers baseballNumbers) {
        BaseballDatabase.baseballNumbers = baseballNumbers;
    }

    public BaseballNumbers find() {
        return BaseballDatabase.baseballNumbers;
    }
}
