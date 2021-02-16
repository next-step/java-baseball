package BaseballGame.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballRecord {
    private static final List<Inning> chart = new ArrayList<>();

    public void recordInningResult(Inning inning) {
        this.chart.add(inning);
    }

    public List<Inning> getChart() {
        return this.chart;
    }

    public Inning getLastInning() {
        return chart.get(chart.size() - 1);
    }
}
