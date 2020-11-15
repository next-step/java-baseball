package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private int generatedValue = 0;
    private final int range = (int) Math.pow(10, 2);
    private List<Integer> unitList = initUnitList();

    public int getNotDuplicatedEachHundredNumber() {
        this.unitList = initUnitList();
        for (int i = range; i > 0; i = i / 10) {
            generatedValue += generateNumberAndSyncUnit() * i;
        }
        if (generatedValue / 100 < 1) {
            generatedValue += generateNumberAndSyncUnit() * range;
        }
        return generatedValue;
    }

    private List<Integer> initUnitList() {
        generatedValue = 0;
        List<Integer> unitList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            unitList.add(i);
        }
        return unitList;
    }

    private Integer generateNumberAndSyncUnit() {
        int random = (int) (Math.random() * (unitList.size() - 1));
        Integer number = unitList.get(random);
        unitList.remove(random);
        return number;
    }
}
