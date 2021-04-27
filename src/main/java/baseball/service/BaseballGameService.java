package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.repository.BaseballNumberRepository;

public class BaseballGameService {

    private final BaseballNumberRepository repository;

    public BaseballGameService() {
        repository = new BaseballNumberRepository();
    }

    public void start() {
        BaseballNumbers baseballNumbers = BaseballNumbers.defenceNumber();
        repository.save(baseballNumbers);
    }

    public BaseballGame pitch(BaseballNumbers pitchNumbers) {
        BaseballNumbers defenceNumbers = repository.find();
        return new BaseballGame(defenceNumbers, pitchNumbers);
    }
}
