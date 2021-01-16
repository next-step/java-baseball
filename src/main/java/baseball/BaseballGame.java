package baseball;

import baseball.presenter.BaseballPresenter;
import baseball.presenter.BaseballPresenterImpl;
import baseball.view.BaseballView;
import baseball.view.BaseballViewImpl;

public class BaseballGame {
    private final BaseballPresenter baseballPresenter = new BaseballPresenterImpl();
    private final BaseballView baseballView = new BaseballViewImpl();

    public void start(){
        baseballPresenter.setBaseBallView(baseballView);
        baseballPresenter.play();
    }
}