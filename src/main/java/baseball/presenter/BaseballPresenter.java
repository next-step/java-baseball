package baseball.presenter;

import baseball.view.BaseballView;

public interface BaseballPresenter {
    void setBaseBallView(BaseballView baseBallView);
    void play();
}